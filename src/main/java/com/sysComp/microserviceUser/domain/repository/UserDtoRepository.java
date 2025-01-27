package com.sysComp.microserviceUser.domain.repository;

import com.sysComp.microserviceUser.domain.UserDto;

public interface UserDtoRepository {
    UserDto getUserByUserName(String username);
}
