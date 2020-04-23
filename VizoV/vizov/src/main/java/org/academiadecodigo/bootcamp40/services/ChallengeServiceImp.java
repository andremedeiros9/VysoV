package org.academiadecodigo.bootcamp40.services;

import org.academiadecodigo.bootcamp40.persistence.dao.ChallengeDao;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.persistence.model.LevelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class ChallengeServiceImp {

    private ChallengeDao challengeDao;

    @Autowired
    public void setChallengeDao(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }


    public int getRandomChallenge(LevelType level){

        switch (level){
            case LEVEL_1:
                return randomizer(LevelType.LEVEL_1.getMin(), LevelType.LEVEL_1.getMax());
            case LEVEL_2:
                return randomizer(LevelType.LEVEL_2.getMin(), LevelType.LEVEL_2.getMax());
            default:
                return randomizer(LevelType.LEVEL_3.getMin(), LevelType.LEVEL_3.getMax());
        }

    }

    public int randomizer(int min, int max){

        Random random = new Random();

        return random.nextInt(((max - min) + 1) + min);
    }

    @Transactional(readOnly = true)
    public Challenge getById(Integer id){
        return challengeDao.findById(id);
    }

}
