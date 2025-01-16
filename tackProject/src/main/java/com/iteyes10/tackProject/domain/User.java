package com.iteyes10.tackProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String uid;
    @Column
    private String pwd;
    @Column
    private Long level;
    @Column
    private String name;
}
