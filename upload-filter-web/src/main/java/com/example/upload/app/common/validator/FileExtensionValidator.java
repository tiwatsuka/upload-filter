package com.example.upload.app.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileExtensionValidator implements ConstraintValidator<FileExtension, MultipartFile> {

	private String[] extensions;
	
	private boolean ignoreCase;
	
	@Override
	public void initialize(FileExtension constraintAnnotation) {
		this.extensions = constraintAnnotation.extensions();
		this.ignoreCase = constraintAnnotation.ignoreCase();
	}

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		for(int i=0; i<extensions.length; i++){
			String fileName = value.getOriginalFilename();
			String extension = extensions[i];
			if(ignoreCase){
				fileName = fileName.toLowerCase();
				extension = extension.toLowerCase();
			}
			if(fileName.endsWith("."+extension)){
				return true;
			}
		}
		return false;
	}

}
