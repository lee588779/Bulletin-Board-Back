package com.iteyes10.taskProject.service;

import com.iteyes10.taskProject.domain.User;
import com.iteyes10.taskProject.repository.UserRepository;
import com.iteyes10.taskProject.vo.LoginRequest;
import com.iteyes10.taskProject.vo.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        //admin account id: admin10
        //admin account pwd: 1q2w3e4r! -> $2a$10$sqJ.wq.JTxckcx5GDlEZXe.aPTi0V39v1mtX7kHVNGXYBoPx9weaC
        //account id: iteyes10
        //account pwd: 1q2w3e4r! -> $2a$10$sqJ.wq.JTxckcx5GDlEZXe.aPTi0V39v1mtX7kHVNGXYBoPx9weaC

        //String pwd = bCryptPasswordEncoder.encode(loginRequest.getPwd());
        String pwd = null;
        try {
            pwd = hashPassword(loginRequest.getPwd());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        System.out.println(pwd);

        Optional<User> user = userRepository.findById(loginRequest.getUid());

        if(user.isPresent()){
            User findUser = user.get();
            if(findUser.getPwd().equals(pwd)){
                return new LoginResponse(findUser.getUid(), findUser.getName());
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
