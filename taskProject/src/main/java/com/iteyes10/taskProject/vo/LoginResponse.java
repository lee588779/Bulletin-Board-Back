package com.iteyes10.taskProject.vo;

import lombok.Data;

@Data
public class LoginResponse {
    private String uid;
    private String name;

    public LoginResponse(){}
    public LoginResponse(String uid, String name){
        this.uid = uid;
        this.name = name;
    }
}
