package com.wisdom.security.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter implements Ordered {

	private static Logger logger = LogManager.getLogger(CORSFilter.class);

	public CORSFilter() {
		super();
		filterOrder = Ordered.HIGHEST_PRECEDENCE + 45;
		try {
			currentNetworkMask = InetAddress.getByName(DEFAULT_SUBNET_MASK);
		} catch (UnknownHostException e) {
			logger.error("Current Network Mask not set to " + DEFAULT_SUBNET_MASK, e);
		}
	}

	private static final String DEFAULT_SUBNET_MASK = "255.255.0.0";

	private static final String URL_WITH_SUBDOMAIN_PATTERN = "^(.*://)?.+?\\.(\\w+\\.[a-z]+)(:\\d+)?$";
	private static final int URL_WITH_SUBDOMAIN_PATTERN_GROUP = 2;

	private static final String URL_WITH_MAINDOMAIN_PATTERN = "^(.*://)?(\\w+\\.[a-z]+)(:\\d+)?$";
	private static final int URL_WITH_MAINDOMAIN_PATTERN_GROUP = 2;

	private static final String URL_WITH_IP_PATTERN = "^(.*://)?([A-Za-z0-9.]+)(:\\d+)?$";
	private static final int URL_WITH_IP_PATTERN_GROUP = 2;

	private InetAddress currentNetworkMask;
	private int filterOrder;

	public InetAddress getCurrentNetworkMask() {
		return currentNetworkMask;
	}

	public void setCurrentNetworkMask(InetAddress currentNetworkMask) {
		this.currentNetworkMask = currentNetworkMask;
	}

	public void setCurrentNetworkMask(String maskAddress) {
		try {
			currentNetworkMask = InetAddress.getByName(maskAddress);
		} catch (UnknownHostException e) {
			logger.error("Current Network Mask not set to " + maskAddress, e);
		}
	}

	@Override
	public int getOrder() {
		return filterOrder;
	}

	public void setOrder(int order) {
		filterOrder = order;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (isRequestAllowed(request)) {
			logger.debug("CORS Request allowed for request with origin '{}' and IP '{}'", request.getHeader("Origin"),
					request.getRemoteAddr());
			setCORSResponseHeaders(request, response);
			if (request != null && !"OPTIONS".equals(request.getMethod())) {
				chain.doFilter(request, response);
			}
		} else {
			logger.warn("CORS Request BLOCKED request with origin '{}' and IP '{}'", request.getHeader("Origin"),
					request.getRemoteAddr());
			response.sendError(HttpServletResponse.SC_FORBIDDEN,
					"The request is from an untrusted source. Source Origin: " + request.getHeader("Origin")
							+ " ; Source IP: " + request.getRemoteAddr());
		}
	}

	private boolean isRequestMethodGet(HttpServletRequest request) {
		return (request.getMethod().equals("GET"));
	}

	private boolean isRequestAllowed(HttpServletRequest request) {
		return (isRequestMethodGet(request) || allowOrigin(request.getHeader("Origin"), request.getServerName())
				|| isSameVpc(request.getRemoteAddr()));
	}

	protected void setCORSResponseHeaders(HttpServletRequest request, HttpServletResponse response) {
		if (response != null && request != null) {
			String origin = request.getHeader("Origin");
			if (origin == null || origin.isEmpty()) {
				response.setHeader("Access-Control-Allow-Origin", "*");
			} else {
				response.setHeader("Access-Control-Allow-Origin", origin);
			}
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Headers",
					"Authorization, x-csrf-token, x-auth-token, Content-Type, ErrorMsg, content-disposition, x-corel, Cookie, applicationName");
			response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
			response.setHeader("Access-Control-Expose-Headers",
					"x-auth-token, x-csrf-token, ErrorMsg, content-disposition, x-corel");
		}
	}

	private boolean isSameSubnet(InetAddress ip1, InetAddress ip2) {
		if (ip1 == null || ip2 == null) {
			return false;
		}
		byte ip1Bytes[] = ip1.getAddress();
		byte ip2Bytes[] = ip2.getAddress();
		byte[] maskBytes = currentNetworkMask.getAddress();
		for (int i = 0; i < ip1Bytes.length; i++) {
			if ((ip1Bytes[i] & maskBytes[i]) != (ip2Bytes[i] & maskBytes[i])) {
				return false;
			}
		}
		return true;
	}

	private Collection<InetAddress> hostIp() {
		try {
			Collection<NetworkInterface> networkInterfaceSet = new HashSet<NetworkInterface>(
					Collections.list(NetworkInterface.getNetworkInterfaces()));
			Collection<InetAddress> ret = new HashSet<>();
			for (NetworkInterface each : networkInterfaceSet) {
				if (!each.isLoopback() && each.isUp()) {
					Enumeration<InetAddress> inetAddressEnum = each.getInetAddresses();
					while (inetAddressEnum.hasMoreElements()) {
						ret.add(inetAddressEnum.nextElement());
					}
				}
			}
			return ret;
		} catch (SocketException e) {
			logger.error("Could not get localhost IP address.");
			return null;
		}
	}

	private boolean isLocalHost(String ip) {
		return (ip.equals("127.0.0.1") || ip.equals("[::1]"));
	}

	private boolean isSameVpc(String remoteIp) {
		if (remoteIp == null || remoteIp.isEmpty()) {
			return false;
		}
		if (isLocalHost(remoteIp)) {
			return true;
		}
		InetAddress remoteAddress;
		try {
			remoteAddress = InetAddress.getByName(remoteIp);
		} catch (UnknownHostException e) {
			logger.error("Cannot set Remote IP '" + remoteIp + "' to InetAddress", e);
			return false;
		}
		if (remoteAddress == null) {
			return false;
		}
		Collection<InetAddress> currentHostIpAddresses = hostIp();
		for (InetAddress eachHost : currentHostIpAddresses) {
			if (isSameSubnet(eachHost, remoteAddress)) {
				return true;
			}
		}
		return false;
	}

	private boolean allowOrigin(String origin, String currentServerName) {
		String originParentDomain = getParentDomain(origin);
		String currentHostParentDomain = getParentDomain(currentServerName);
		logger.debug("allowOrigin():: origin: '{}' ;; currentServerName: {}", origin, currentServerName);
		return (originParentDomain != null && !originParentDomain.isEmpty()
				&& originParentDomain.equals(currentHostParentDomain));
	}

	private String getParentDomain(String url) {
		if (url == null || url.isEmpty()) {
			return "";
		}
		String parentDomain = getParentDomainFromUrlWithSubDomain(url);
		if (parentDomain == null) {
			parentDomain = getParentDomainFromUrlWithMainDomain(url);
		}
		if (parentDomain == null) {
			parentDomain = getParentDomainFromUrlWithIp(url);
		}
		return parentDomain;
	}

	private String getParentDomainFromUrlWithMainDomain(String url) {
		Pattern pattern = Pattern.compile(URL_WITH_MAINDOMAIN_PATTERN);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find() && matcher.groupCount() >= URL_WITH_MAINDOMAIN_PATTERN_GROUP) {
			return matcher.group(URL_WITH_MAINDOMAIN_PATTERN_GROUP);
		}
		return null;
	}

	private String getParentDomainFromUrlWithIp(String url) {
		Pattern pattern = Pattern.compile(URL_WITH_IP_PATTERN);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find() && matcher.groupCount() >= URL_WITH_IP_PATTERN_GROUP) {
			return matcher.group(URL_WITH_IP_PATTERN_GROUP);
		}
		return null;
	}

	private String getParentDomainFromUrlWithSubDomain(String url) {
		Pattern pattern = Pattern.compile(URL_WITH_SUBDOMAIN_PATTERN);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find() && matcher.groupCount() >= URL_WITH_SUBDOMAIN_PATTERN_GROUP) {
			return matcher.group(URL_WITH_SUBDOMAIN_PATTERN_GROUP);
		}
		return null;
	}
}
