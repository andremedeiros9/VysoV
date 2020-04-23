package org.academiadecodigo.bootcamp40.controllers.rest;

import org.academiadecodigo.bootcamp40.converters.UserToUserDto;
import org.academiadecodigo.bootcamp40.dto.UserDto;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")
public class RestProfileController {

    private UserServiceImp userServiceImp;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> showProfile(@PathVariable Integer id) {

        User user = userServiceImp.getById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userToUserDto.convert(user), HttpStatus.OK);
    }
}

