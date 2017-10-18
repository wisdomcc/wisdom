package com.wisdom.service.utility;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	public String uploadImage(MultipartFile file, String questionId, String option);
	
}
