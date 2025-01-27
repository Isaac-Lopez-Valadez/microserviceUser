package com.sysComp.microserviceUser.persitence.crud;

import com.sysComp.microserviceUser.persitence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User, Integer> {

    public User findByUserName(String userName);
}
