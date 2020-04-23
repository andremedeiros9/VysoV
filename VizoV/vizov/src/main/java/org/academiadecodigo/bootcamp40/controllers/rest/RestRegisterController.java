package org.academiadecodigo.bootcamp40.controllers.rest;

import org.academiadecodigo.bootcamp40.converters.UserDtoToUser;
import org.academiadecodigo.bootcamp40.dto.UserDto;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class RestRegisterController {

    private UserServiceImp userServiceImp;
    private UserDtoToUser userDtoToUser;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if(bindingResult.hasErrors() || userDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User savedUser = userServiceImp.save(userDtoToUser.convert(userDto));

        if (savedUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UriComponents uriComponents = uriComponentsBuilder.path("/api/profile" + savedUser.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
