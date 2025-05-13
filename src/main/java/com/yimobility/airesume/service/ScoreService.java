package com.yimobility.airesume.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimobility.airesume.Model.JobDescription;
//import com.yimobility.airesume.repo.ScoreRepository;

@Service

public class ScoreService{
	
//	 @Autowired
//	 private ScoreRepository scoreRepository;
	 
	  @Autowired
	  private TextStorageService textStorageService;
	 
	 public void saveTextData(String description) {
		 JobDescription data = new JobDescription();

         data.setText(description);
//         System.out.println(scoreRepository.save(data));
         textStorageService.setJobDescription(description);
        // scoreRepository.save(data);

     }
	 
	 
	
}