package com.iteyes10.taskProject.service;

import com.iteyes10.taskProject.domain.User;
import com.iteyes10.taskProject.repository.UserRepository;
import com.iteyes10.taskProject.vo.LoginRequest;
import com.iteyes10.taskProject.vo.LoginResponse;
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

    public LoginResponse login(LoginRequest loginRequest) {
        //account id: iteyes10
        //account pwd: 1q2w3e4r! -> $2a$12$9UJlyVTAZ2lcKje/n.QbQ.4doxxL.YHmeknpOHRUPb0VN3yNqJy7m

        String pwd = bCryptPasswordEncoder.encode(loginRequest.getPwd());

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
