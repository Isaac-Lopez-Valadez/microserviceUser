package com.sysComp.microserviceUser.domain.service;

import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.persitence.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepositoryImpl userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDto getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }

    public UserDto saveUser(UserDto user) {
        System.out.println("AQUIIIIIIIII" + user.toString());
        return userRepository.saveUser(user);
    }


}
