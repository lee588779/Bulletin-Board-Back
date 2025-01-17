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
public class User {
    @Id
    private String uid;
    @Column
    private String pwd;
    @Column
    private String level;
    @Column
    private String name;
    @Column
    private LocalDate regdt;
}
