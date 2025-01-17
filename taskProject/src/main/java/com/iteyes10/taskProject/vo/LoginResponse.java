package com.iteyes10.taskProject.vo;

import lombok.Data;

@Data
public class LoginResponse {
    private String uid;
    private String name;
    private String level;

    public LoginResponse(){}
    public LoginResponse(String uid, String name, String level){
        this.uid = uid;
        this.name = name;
        this.level = level;
    }
}
