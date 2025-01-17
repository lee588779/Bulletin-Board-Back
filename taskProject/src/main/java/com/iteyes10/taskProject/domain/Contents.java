package com.iteyes10.taskProject.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    
}
