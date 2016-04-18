package com.example.upload.app.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

public class MultipartSecurityFilter extends OncePerRequestFilter {
	
	private int maxFileNum;
	
	private int maxTextParamNum;

	private long maxTextSize;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request instanceof MultipartRequest){
			MultipartRequest multipartRequest = (MultipartRequest)request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			
			if(fileMap.size() > maxFileNum){
				throw new RuntimeException("Max number of files is exceeded.");
			}
			
			fileMap.entrySet()
			       .stream()
			       .forEach((Map.Entry<String,MultipartFile> e)->{/*check char encoding*/});
			
			Map<String, String[]> textParamMap = request.getParameterMap(); 
			if(textParamMap.size() > maxTextParamNum){
				throw new RuntimeException("Max number of text parameter is exceeded.");
			}
			textParamMap.entrySet()
			            .stream()
			            .forEach((Map.Entry<String, String[]> e)->{
			            	checkTextParamLength(e.getValue(), request.getCharacterEncoding());
			            	});
		}
		filterChain.doFilter(request, response);
	}
	
	private void checkTextParamLength(String[] values, String encoding){
		for(int i=0; i<values.length; i++){
			try {
				if(values[i].getBytes(encoding).length > maxTextSize){
					throw new RuntimeException("Max size of text parameter is exceeded.");
				}
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void setMaxFileNum(int maxFileNum) {
		this.maxFileNum = maxFileNum;
	}
	
	public void setMaxTextParamNum(int maxTextParamNum) {
		this.maxTextParamNum = maxTextParamNum;
	}

	public void setMaxTextSize(long maxTextSize) {
		this.maxTextSize = maxTextSize;
	}

}
