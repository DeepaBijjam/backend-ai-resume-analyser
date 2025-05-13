package com.yimobility.airesume.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ChatService{
	
	@Autowired
    private ChatClient.Builder builder;
	
//	 public static String removeLastComma(String str) {
//	        if (str == null || str.isEmpty()) {
//	            return str;
//	        }
//	        if (str.endsWith(",")) {
//	            str = str.substring(0, str.length() - 1);
//	        }
//	        return str;
//	    }

    public String compareResumeWithJobDescription(String extractedFileText,String jobDescriptionText) {
        var client = builder.build();

        String comparisonPrompt = "I will give you a resume and a job description.Compare the resume against the job description and provide the following information:\n" +
        						  "Resume:\n"+extractedFileText+
        						  "Job Description:\n"+jobDescriptionText+
        						  
        						  "Return only the following,each on a new line with heading each, remove highlight and provide these details only json object without any extry heading at the top ```json and bottom like ```: "+
        						  "- A Single number score out of 10"+
        						  "- Good points in detail"+
        						  "-Missing points in detail"+
        						  "-Possible additional points in detail"+
        						  
        						  "Be concise and to the point and underline at heading score,good points,missing points and possible additional points.";
                               
        
        
      String extractedOutput= client.prompt(comparisonPrompt).call().content();
      
//      String boldStart = "\033[0;1m"; // ANSI bold start
//      String boldEnd = "\033[0;0m";   // ANSI bold end
    
      String extractedNewOutput = extractedOutput.replace("```", "")
    		  					  .replace("json", "")
    		  					  .replace("{", "")
    		  					  .replace("}", "")
    		  					  .replace("[", "")
    		  					  .replace("],", "],\n ")
    		  					  .replace("],", "")
    		  					  .replace("\"", "")
    		  					  .replace("]", "")
    		  					  .replaceAll("\\s*,\\s*\n", "\n");
      
//      extractedNewOutput = extractedNewOutput.replace("Score:", boldStart + "Score:" + boldEnd)
//              .replace("Good points in detail:", boldStart + "Good points in detail:" + boldEnd)
//              .replace("Missing points in detail:", boldStart + "Missing points in detail:" + boldEnd)
//              .replace("Possible additional points in detail:", boldStart + "Possible additional points in detail:" + boldEnd);
//      
        return extractedNewOutput ;
        
}
}