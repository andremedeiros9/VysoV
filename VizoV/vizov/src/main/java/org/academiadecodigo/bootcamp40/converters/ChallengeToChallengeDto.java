package org.academiadecodigo.bootcamp40.converters;

import org.academiadecodigo.bootcamp40.dto.ChallengeDto;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChallengeToChallengeDto extends AbstractConverter<Challenge, ChallengeDto>  {

    @Override
    public ChallengeDto convert(Challenge challenge) {

        ChallengeDto challengeDto = new ChallengeDto();
        challengeDto.setId(challenge.getId());
        challengeDto.setTitle(challenge.getTitle());
        challengeDto.setDescription(challenge.getDescription());
        challengeDto.setLevel(challenge.getLevel());

        return challengeDto;
    }
}
