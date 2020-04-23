package org.academiadecodigo.bootcamp40.converters;

import org.academiadecodigo.bootcamp40.dto.ChallengeDto;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.services.ChallengeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChallengeDtoToChallenge implements Converter<ChallengeDto, Challenge> {

    private ChallengeServiceImp challengeServiceImp;

    @Override
    public Challenge convert(ChallengeDto challengeDto) {

        Challenge challenge = (challengeDto.getId() != null ? challengeServiceImp.getById(challengeDto.getId()) : new Challenge());

        challenge.setTitle(challengeDto.getTitle());
        challenge.setDescription(challengeDto.getDescription());
        challenge.setLevel(challengeDto.getLevel());

        return challenge;
    }

    @Autowired
    public void setChallengeServiceImp(ChallengeServiceImp challengeServiceImp) {
        this.challengeServiceImp = challengeServiceImp;
    }

}
