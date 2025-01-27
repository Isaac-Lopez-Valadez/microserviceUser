package com.sysComp.microserviceUser.persitence.mapper;

import com.sysComp.microserviceUser.domain.UserDto;
import com.sysComp.microserviceUser.persitence.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-26T23:28:27-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( user.getAge() != null ) {
            userDto.setAge( user.getAge() );
        }
        if ( user.getStatus() != null ) {
            userDto.setStatus( user.getStatus() );
        }
        if ( user.getUserLevel() != null ) {
            userDto.setUserLevel( user.getUserLevel() );
        }
        if ( user.getUserID() != null ) {
            userDto.setUserID( user.getUserID() );
        }
        userDto.setUserName( user.getUserName() );
        userDto.setName( user.getName() );
        userDto.setLastname( user.getLastname() );
        userDto.setEmail( user.getEmail() );
        userDto.setAddress( user.getAddress() );
        userDto.setPhoneNumber( user.getPhoneNumber() );

        return userDto;
    }

    @Override
    public List<UserDto> toUsersDto(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setAge( userDto.getAge() );
        user.setStatus( userDto.isStatus() );
        user.setUserLevel( userDto.getUserLevel() );
        user.setUserName( userDto.getUserName() );
        user.setName( userDto.getName() );
        user.setLastname( userDto.getLastname() );
        user.setEmail( userDto.getEmail() );
        user.setAddress( userDto.getAddress() );
        user.setPhoneNumber( userDto.getPhoneNumber() );

        return user;
    }
}
