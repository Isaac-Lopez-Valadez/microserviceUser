package com.sysComp.microserviceUser.persitence;


import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.domain.repository.UserDtoRepository;
import com.sysComp.microserviceUser.persitence.crud.UserRespository;
import com.sysComp.microserviceUser.persitence.entity.User;
import com.sysComp.microserviceUser.persitence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserDtoRepository {
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRespository.findAll();
        return userMapper.toUsersDto(users);
    }

    @Override
    public UserDto getUserByUserName(String username) {
        return userMapper.toUserDto(userRespository.findByUserName(username));
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        System.out.println("HOLA DAtos ----" + user.toString());
        return userMapper.toUserDto(userRespository.save(user));
    }
}
