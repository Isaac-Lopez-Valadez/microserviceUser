package com.sysComp.microserviceUser.domain.repository;

import com.sysComp.microserviceUser.domain.UserDto;

import java.util.List;

public interface UserDtoRepository {

    List<UserDto> getActiveUsers(boolean status);
    UserDto getUserByUserName(String username);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(int userID);
}
