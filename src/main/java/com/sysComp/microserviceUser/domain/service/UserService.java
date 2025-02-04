package com.sysComp.microserviceUser.domain.service;

import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.persitence.UserRepositoryImpl;
import jakarta.transaction.Transactional;
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

    public List<UserDto> getActiveUsers() { return userRepository.getActiveUsers(true); };

    public UserDto getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }

    public UserDto saveUser(UserDto user) {
        user.setUserID(null);
        return userRepository.saveUser(user);
    }

    @Transactional
    public UserDto updateUser(UserDto user) {
        UserDto userUpdated = userRepository.getUserByID(user.getUserID());
        userUpdated.setUserName(user.getUserName());
        userUpdated.setName(user.getName());
        userUpdated.setLastname(user.getLastname());
        userUpdated.setAddress(user.getAddress());
        userUpdated.setAge(user.getAge());
        userUpdated.setPhoneNumber(user.getPhoneNumber());
        userUpdated.setUserLevel(user.getUserLevel());
        return userRepository.updateUser(userUpdated);
    }

    public void deleteUser(int userID) {
        userRepository.deleteUser(userID);
    }

}
