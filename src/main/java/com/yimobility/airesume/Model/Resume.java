package com.yimobility.airesume.Model;
//import jakarta.persistence.*;
//import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//@Entity
@Data
@AllArgsConstructor

public class Resume {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
   

//    @Lob
    private byte[] data;


    public Resume(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
           
        }

    public Resume() {

    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public byte[] getData() {
        return data;
    }
   
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
   
}
