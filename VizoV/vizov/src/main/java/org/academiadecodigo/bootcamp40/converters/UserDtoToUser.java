package org.academiadecodigo.bootcamp40.converters;

import org.academiadecodigo.bootcamp40.dto.UserDto;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    private UserServiceImp userServiceImp;

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    public User convert(UserDto userDto){
        
        User user = (userDto.getId() != null ? userServiceImp.getById(userDto.getId()) : new User());

        user.setUserName(user.getUserName());

        user.setEmail(user.getEmail());

        return user;
    }
}
