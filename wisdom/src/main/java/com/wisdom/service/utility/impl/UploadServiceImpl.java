package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.wisdom.service.utility.AmazonS3Service;
import com.wisdom.service.utility.UploadService;

public class UploadServiceImpl implements UploadService {

	private final String QUESTION_IMG_UPDOAD_DIRECTORY = "uploadedfiles/";
	private final String BUCKET_NAME = "wisdomcc";

	@Autowired
	private AmazonS3Service amazonS3Service;

	@Override
	public String uploadImage(MultipartFile multipartFile, String questionId, String type) {
		String destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId;
		makeDirectory(destinationPath);
		if ("question".equals(type)) {
			destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId;
		} else if ("option".equals(type)) {
			destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId + "/option";
			makeDirectory(destinationPath);
		} else if ("paragraph".equals(type)) {
			destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId + "/paragraph";
			makeDirectory(destinationPath);
		} else if ("answer".equals(type)) {
			destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId + "/answer";
			makeDirectory(destinationPath);
		}
		int fileCount = getFileCount(destinationPath);
		String origFileName = multipartFile.getOriginalFilename();
		String extension = origFileName.substring(origFileName.indexOf("."), origFileName.length());
		String path = destinationPath + "/" + "image" + fileCount + extension;
		amazonS3Service.uploadFile(BUCKET_NAME, path, multipartFile);
		return path;
	}

	private void makeDirectory(String destinationPath) {
		amazonS3Service.createFolder(BUCKET_NAME, destinationPath);
	}

	private int getFileCount(String destinationPath) {
		return amazonS3Service.getFileCount(BUCKET_NAME, destinationPath);
	}

}
