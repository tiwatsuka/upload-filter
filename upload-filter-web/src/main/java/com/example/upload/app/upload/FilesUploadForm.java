package com.example.upload.app.upload;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FilesUploadForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Valid
	private List<FileUploadForm> fileUploadForms;
	
	@NotNull
	private String comment;

	public List<FileUploadForm> getFileUploadForms() {
		return fileUploadForms;
	}

	public void setFileUploadForms(List<FileUploadForm> fileUploadForms) {
		this.fileUploadForms = fileUploadForms;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
