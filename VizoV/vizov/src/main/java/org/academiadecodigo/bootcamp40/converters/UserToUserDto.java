package org.academiadecodigo.bootcamp40.converters;

import org.academiadecodigo.bootcamp40.dto.UserDto;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverter<User, UserDto>{

    @Override
    public UserDto convert(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
