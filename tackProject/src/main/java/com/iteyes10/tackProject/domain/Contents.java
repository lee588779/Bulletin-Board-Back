package com.iteyes10.tackProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contents {
    @Id
    private String uid;
    @Column
    private String title;
    @Column
    private String text;
}
