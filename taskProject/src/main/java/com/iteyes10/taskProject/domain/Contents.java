package com.iteyes10.taskProject.domain;

import java.time.LocalDate;

import com.iteyes10.taskProject.dto.write_data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Column
    private String uid;

    @Column
    private String title;

    @Column
    private String text;
    
    @Column
    private LocalDate regdt;

    @Column
    private String status;

    @Column 
    private String type;
    
    public Contents(write_data data, String uid) {
        this.uid = uid;
        this.title = data.getTitle();
        this.text = data.getText();
        this.regdt = LocalDate.now();
        this.status = "activate";
        this.type = data.getType();
    }
}
