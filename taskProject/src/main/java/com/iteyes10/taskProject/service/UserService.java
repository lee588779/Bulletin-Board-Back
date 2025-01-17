package com.iteyes10.taskProject.service;

import com.iteyes10.taskProject.domain.User;
import com.iteyes10.taskProject.repository.UserRepository;
import com.iteyes10.taskProject.vo.LoginRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String login(LoginRequest loginRequest) {
        String pwd = bCryptPasswordEncoder.encode(loginRequest.getPwd());

        Optional<User> user = userRepository.findById(loginRequest.getUid());

        if(user.isPresent()){
            User findUser = user.get();
            if(findUser.getPwd().equals(pwd)){
                return findUser.getUid();
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
