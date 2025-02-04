package com.sysComp.microserviceUser.persitence.crud;

import com.sysComp.microserviceUser.persitence.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Integer> {

    public List<User> findByStatus(boolean status);

    public User findByUserName(String userName);
}
