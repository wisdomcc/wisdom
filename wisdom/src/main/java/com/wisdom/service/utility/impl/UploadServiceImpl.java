package com.wisdom.service.utility.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.wisdom.service.utility.UploadService;

public class UploadServiceImpl implements UploadService {
	
	private final String QUESTION_IMG_UPDOAD_DIRECTORY = "src/main/resources/static/uploadedfiles/";
	
	@Override
	public String uploadImage(MultipartFile multipartFile, String questionId, String type) {
		try {
			String destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId;
			makeDirectory(destinationPath);
			if("question".equals(type)) {
				destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId;
			} else if("option".equals(type)) {
				destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId + "/option";
				makeDirectory(destinationPath);
			} else if("paragraph".equals(type)) {
				destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId + "/paragraph";
				makeDirectory(destinationPath);
			} else if("answer".equals(type)) {
				destinationPath = QUESTION_IMG_UPDOAD_DIRECTORY + questionId + "/answer";
				makeDirectory(destinationPath);
			}
			int fileCount = getFileCount(destinationPath);
			String origFileName = multipartFile.getOriginalFilename();
			String extension = origFileName.substring(origFileName.indexOf("."), origFileName.length());
		    File file = new File(destinationPath + "/"  + "image" + fileCount + extension);
		    multipartFile.transferTo(new File(file.getAbsolutePath()));
		    destinationPath = destinationPath.replaceAll("src/main/resources/static", "");
		    return destinationPath + "/image" + fileCount + extension;
		} catch (IOException e) {
			return null;
		}
	}

	private void makeDirectory(String destinationPath) {
		File directory = new File(destinationPath);
		if(!directory.exists()) {
			directory.mkdir();
		}
	}

	private int getFileCount(String destinationPath) {
		File directory = new File(destinationPath);
		int fileCount = 0;
		for(File f : directory.listFiles()) {
			if(!f.isDirectory()) {
				++fileCount;
			}
		}
		return fileCount;
	}

}
