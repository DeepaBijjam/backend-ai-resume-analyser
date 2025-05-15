package com.yimobility.airesume.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yimobility.airesume.service.ChatService;

import com.yimobility.airesume.service.TextStorageService;



@RestController
@RequestMapping("/api")
@CrossOrigin

public class ChatController{
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private TextStorageService textStorageService;
	
	
	@PostMapping( "/resumemarks")
	public String scoreResume() throws IOException {
	    String resumeText = textStorageService.getExtractedText();
	    String jobDescriptionText = textStorageService.getDescription();
	    return chatService.compareResumeWithJobDescription(resumeText,jobDescriptionText);
	}
	
}