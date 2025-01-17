package com.iteyes10.taskProject.service;

import com.iteyes10.taskProject.domain.User;
import com.iteyes10.taskProject.repository.UserRepository;
import com.iteyes10.taskProject.vo.LoginRequest;
import com.iteyes10.taskProject.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(password.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }

    public LoginResponse login(LoginRequest loginRequest) {

        String pwd = null;
        try {
            pwd = hashPassword(loginRequest.getPwd());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Optional<User> user = userRepository.findById(loginRequest.getUid());

        if(user.isPresent()){
            User findUser = user.get();
            if(findUser.getPwd().equals(pwd)){
                return new LoginResponse(findUser.getUid(), findUser.getName(), findUser.getLevel());
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
