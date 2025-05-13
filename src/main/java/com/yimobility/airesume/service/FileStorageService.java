package com.yimobility.airesume.service;

import com.yimobility.airesume.Model.Resume;


//import com.yimobility.airesume.repo.FileDataRepository;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;


@Service
public class FileStorageService {


//    @Autowired
//    private FileDataRepository fileDataRepository;
    
    @Autowired
    private TextStorageService textStorageService;


    public void uploadFile(MultipartFile file) throws IOException {
        Resume fileData = new Resume();
        fileData.setName(file.getOriginalFilename());
        fileData.setType(file.getContentType());
        fileData.setData(file.getBytes());
        
        // Save the file data to the database
//      fileDataRepository.save(fileData);
//      String extractedText = extractTextFromWordDocument(file);
      
      String extractedText = extractTextFromDocument(file);
        textStorageService.setExtractedText(extractedText);


    }


//    public String extractTextFromWordDocument(MultipartFile file) throws IOException {
//        try (InputStream inputStream = file.getInputStream()) {
//            XWPFDocument document = new XWPFDocument(inputStream);
//            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
//            System.out.println(extractor.getText());
//            return extractor.getText();
//        }
//    }

    
    

    public String extractTextFromDocument(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            throw new IOException("Invalid file name.");
        }

        if (fileName.endsWith(".docx")) {
            try (InputStream inputStream = file.getInputStream()) {
                XWPFDocument document = new XWPFDocument(inputStream);
                XWPFWordExtractor extractor = new XWPFWordExtractor(document);
                return extractor.getText();
            }
        } else if (fileName.endsWith(".pdf")) {
            try (InputStream inputStream = file.getInputStream();
                 PDDocument pdfDocument = PDDocument.load(inputStream)) {
                PDFTextStripper stripper = new PDFTextStripper();
                return stripper.getText(pdfDocument);
            }
        } else {
            throw new IOException("Unsupported file format.");
        }
    }

}




