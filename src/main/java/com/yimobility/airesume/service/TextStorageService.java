package com.yimobility.airesume.service;

import org.springframework.stereotype.Service;

@Service
public class TextStorageService {

    private String extractedText;
    private String jobDescription;
    
    public void setExtractedText(String text) {
        this.extractedText = text;
    }

    public String getExtractedText() {
        return this.extractedText;
    }

    public void clearText() {
        this.extractedText = null;
    }
    
    
    public void setJobDescription(String description) {
        this.jobDescription = description;
    }

    public String getDescription() {
        return this.jobDescription;
    }
}