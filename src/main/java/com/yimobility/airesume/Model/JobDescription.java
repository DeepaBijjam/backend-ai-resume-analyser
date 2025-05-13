package com.yimobility.airesume.Model;


//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDescription {
//	 @Id
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	public String getDescription() {
        return description;
    }
	  public void setText(String description) {
	    	this.description = description;
	    }
}