package com.sysComp.microserviceUser.persitence.mapper;

import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.persitence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "userLevel", target = "userLevel")
    })
    UserDto toUserDto(User user);
    List<UserDto> toUsersDto(List<User> users);

    @InheritInverseConfiguration
    User toUser(UserDto userDto);
}
