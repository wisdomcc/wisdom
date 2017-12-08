package com.wisdom.service.utility.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
// import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
// import com.amazonaws.services.s3.transfer.TransferManager;
// import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.wisdom.service.utility.AmazonS3Service;

public class AmazonS3ServiceImpl implements AmazonS3Service {

	private static Logger LOG = LogManager.getLogger(AmazonS3ServiceImpl.class);
	private static final String SUFFIX = "/";

	private static AmazonS3Service amazonS3Service = null;
	// private static TransferManager transferManager = null;
	private static AmazonS3 amazonS3 = null;

	public AmazonS3ServiceImpl() {
	}

	public static AmazonS3Service getInstance(String accessKey, String secretKey, String regionName) {
		try {
			LOG.debug("AccessKey:{} :: SecretKey:{}  :: RegionName:{} ", accessKey, secretKey, regionName);
			if (amazonS3Service == null) {
				amazonS3Service = new AmazonS3ServiceImpl(accessKey, secretKey, regionName);
			}
			LOG.debug("Connected to S3 successfully");
		} catch (Exception e) {
			LOG.error("Error while connecting to S3, Exception:{}", e);
		}
		return amazonS3Service;
	}

	private AmazonS3ServiceImpl(String accessKey, String secretKey, String regionName) {
		try {
			SystemPropertiesCredentialsProvider classPath = new SystemPropertiesCredentialsProvider();
			System.setProperty("aws.accessKeyId", accessKey);
			System.setProperty("aws.secretKey", secretKey);
			AWSCredentials credentials = classPath.getCredentials();

			AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);
			amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(credentialsProvider).withRegion(regionName)
					.build();
			// amazonS3.setS3ClientOptions(S3ClientOptions.builder().disableChunkedEncoding().build());
			// transferManager =
			// TransferManagerBuilder.standard().withS3Client(amazonS3).build();
		} catch (Exception exception) {
			LOG.error("Error while connecting to S3, Exception:{}", exception);
		}
	}

	/**
	 * This Method will upload file to S3.
	 * 
	 * @param bucketName
	 * @param fileNameOnS3
	 * @param inputFilePath
	 * @throws AmazonServiceException,
	 *             AmazonClientException
	 */
	@Override
	public boolean uploadFile(final String bucketName, final String path, final MultipartFile inputFile) {
		try {
			InputStream stream = inputFile.getInputStream();
			ObjectMetadata objectMetadata = new ObjectMetadata();
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, path, stream, objectMetadata);
			amazonS3.putObject(putObjectRequest);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * This Method will create folder in S3.
	 * 
	 * @param bucketName
	 * @param folderName
	 * 
	 */
	@Override
	public void createFolder(String bucketName, String folderName) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + SUFFIX, emptyContent,
				metadata);
		// send request to S3 to create folder
		amazonS3.putObject(putObjectRequest);
	}

	/**
	 * This Method will get file list from specified folder in S3.
	 * 
	 * @param bucketName
	 * @param folderName
	 * 
	 */
	@Override
	public int getFileCount(String bucketName, String folderName) {
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName)
				.withPrefix(folderName + "/");
		ObjectListing objects = amazonS3.listObjects(listObjectsRequest);
		List<S3ObjectSummary> summaries = objects.getObjectSummaries();
		int fileCount = 0;
		for(S3ObjectSummary objSummary : summaries) {
			if(objSummary.getKey().indexOf(folderName + "/image") > -1) {
				++fileCount;
			}
		}
		return fileCount;
	}

}
