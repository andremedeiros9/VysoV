package org.academiadecodigo.bootcamp40.controllers.rest;

import org.academiadecodigo.bootcamp40.converters.ChallengeDtoToChallenge;
import org.academiadecodigo.bootcamp40.converters.ChallengeToChallengeDto;
import org.academiadecodigo.bootcamp40.dto.ChallengeDto;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/challenge")
public class RestChallengeController {

    private UserServiceImp userServiceImp;
    private ChallengeToChallengeDto challengeToChallengeDto;
    private ChallengeDtoToChallenge challengeDtoToChallenge;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setChallengeToChallengeDto(ChallengeToChallengeDto challengeToChallengeDto) {
        this.challengeToChallengeDto = challengeToChallengeDto;
    }

    @Autowired
    public void setChallengeDtoToChallenge(ChallengeDtoToChallenge challengeDtoToChallenge) {
        this.challengeDtoToChallenge = challengeDtoToChallenge;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChallengeDto> showChallenge(@PathVariable Integer id){

        Challenge challenge = userServiceImp.getNewChallenge(userServiceImp.getById(id));

        if (challenge == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(challengeToChallengeDto.convert(challenge), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public void addCompletedChallenge(@PathVariable Integer id, @Valid @RequestBody ChallengeDto challengeDto) {

        Challenge savedChallenge = challengeDtoToChallenge.convert(challengeDto);
        userServiceImp.completedChallenge(id, savedChallenge);
    }
}
