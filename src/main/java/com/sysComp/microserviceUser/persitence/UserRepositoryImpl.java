package com.sysComp.microserviceUser.persitence;


import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.domain.repository.UserDtoRepository;
import com.sysComp.microserviceUser.persitence.crud.UserCrudRepository;
import com.sysComp.microserviceUser.persitence.entity.User;
import com.sysComp.microserviceUser.persitence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserDtoRepository {
    @Autowired
    private UserCrudRepository userRespository;
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRespository.findAll();
        return userMapper.toUsersDto(users);
    }

    public UserDto getUserByID(int userID){
        return userMapper.toUserDto(userRespository.findById(userID).get());
    }

    @Override
    public List<UserDto> getActiveUsers(boolean status) {
        return userMapper.toUsersDto(userRespository.findByStatus(status));
    }

    @Override
    public UserDto getUserByUserName(String username) {
        return userMapper.toUserDto(userRespository.findByUserName(username));
    }
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        return userMapper.toUserDto(userRespository.save(user));
    }
    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        return userMapper.toUserDto(userRespository.save(user));
    }

    @Override
    public void deleteUser(int userID) {
        userRespository.deleteById(userID);
    }
}
