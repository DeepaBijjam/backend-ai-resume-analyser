package com.yimobility.airesume.controller;

import com.yimobility.airesume.Model.JobDescription;

import java.io.IOException;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yimobility.airesume.service.FileStorageService;
import com.yimobility.airesume.service.ScoreService;

@RestController
@RequestMapping("/api")
@CrossOrigin


public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	
	
	@PostMapping("/savetext")
	
	   public ResponseEntity<String> saveTextData(@RequestBody JobDescription jobdescription) {
		try {
        scoreService.saveTextData(jobdescription.getDescription());
        return new ResponseEntity<>("Text saved successfully", HttpStatus.OK);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload the job description: " + "!");
		}
    }
	
	

//	private final ChatClient.Builder builder;
//
//    // Correct constructor without 'void'
//    public ScoreController(ChatClient.Builder builder) {
//        this.builder = builder;
//    }
//
//    @GetMapping("/score")
//    public String getSriRamaNavamiInfo() {
//        var client = builder.build();
//        return client.prompt("Tell me about Sri Rama Navami festival")
//                     .call()
//                     .content();
//    }
//    
//    public String getSriRamaNavamiInfo(@RequestParam("file") MultipartFile file,JobDescription jobdescription) {
//    	String jobDescription = scoreService.saveTextData(jobdescription);
//      var client = builder.build();
//      return client.prompt("Tell me about Sri Rama Navami festival")
//                   .call()
//                   .content();
//  }
}
	
