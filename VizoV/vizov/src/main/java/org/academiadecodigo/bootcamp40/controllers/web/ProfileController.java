package org.academiadecodigo.bootcamp40.controllers.web;

import org.academiadecodigo.bootcamp40.converters.ChallengeDtoToChallenge;
import org.academiadecodigo.bootcamp40.converters.ChallengeToChallengeDto;
import org.academiadecodigo.bootcamp40.converters.UserDtoToUser;
import org.academiadecodigo.bootcamp40.converters.UserToUserDto;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private UserServiceImp userServiceImp;

    private UserToUserDto userToUserDto;
    private UserDtoToUser userDtoToUser;
    private ChallengeDtoToChallenge challengeDtoToChallenge;
    private ChallengeToChallengeDto challengeToChallengeDto;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @Autowired
    public void setChallengeDtoToChallenge(ChallengeDtoToChallenge challengeDtoToChallenge) {
        this.challengeDtoToChallenge = challengeDtoToChallenge;
    }

    @Autowired
    public void setChallengeToChallengeDto(ChallengeToChallengeDto challengeToChallengeDto) {
        this.challengeToChallengeDto = challengeToChallengeDto;
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Integer id, Model model) throws Exception{

        User user = userServiceImp.getById(id);

        model.addAttribute("user", userToUserDto.convert(user));
        model.addAttribute("challenges", challengeToChallengeDto.convert(userServiceImp.getMyChallenges(id)));

        return "profile";
    }




}
