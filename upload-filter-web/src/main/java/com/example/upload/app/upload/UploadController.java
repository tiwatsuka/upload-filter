package com.example.upload.app.upload;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@ModelAttribute
	public FilesUploadForm filesUploadForm(){
		return new FilesUploadForm();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String createForm(){
		return "upload/filesUploadForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postForm(@Validated FilesUploadForm filesUploadForm, BindingResult result){
		if(result.hasErrors()){
			return "redirect:upload";
		}
		return "upload/uploadCompleted";
	}
	
}
