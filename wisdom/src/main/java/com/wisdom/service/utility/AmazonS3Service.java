package com.wisdom.service.utility;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3Service {

	public boolean uploadFile(final String bucketName, String path, final MultipartFile inputFile);
	public void createFolder(String bucketName, String folderName);
	public int getFileCount(String bucketName, String folderName);

}
