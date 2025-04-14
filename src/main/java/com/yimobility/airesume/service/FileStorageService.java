package com.yimobility.airesume.service;

import com.yimobility.airesume.Model.Resume;


import com.yimobility.airesume.repo.FileDataRepository;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Service
public class FileStorageService {


    @Autowired
    private FileDataRepository fileDataRepository;
    
    @Autowired
    private TextStorageService textStorageService;

//    public FileStorageService(FileDataRepository fileDataRepository) {
//        this.fileDataRepository = fileDataRepository;
//    }

    public void uploadFile(MultipartFile file) throws IOException {
        Resume fileData = new Resume();
        fileData.setName(file.getOriginalFilename());
        fileData.setType(file.getContentType());
        fileData.setData(file.getBytes());
        
        // Save the file data to the database
      fileDataRepository.save(fileData);
      String extractedText = extractTextFromWordDocument(file);
        textStorageService.setExtractedText(extractedText);


    }


    public String extractTextFromWordDocument(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            XWPFDocument document = new XWPFDocument(inputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            System.out.println(extractor.getText());
            return extractor.getText();
        }
    }

    
    



}




