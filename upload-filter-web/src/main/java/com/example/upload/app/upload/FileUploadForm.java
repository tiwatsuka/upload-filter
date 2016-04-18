package com.example.upload.app.upload;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.example.upload.app.common.validator.FileExtension;

public class FileUploadForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@FileExtension(extensions={"jpg"}, ignoreCase=true)
	private MultipartFile file;
	
	@NotNull
	private String description;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
