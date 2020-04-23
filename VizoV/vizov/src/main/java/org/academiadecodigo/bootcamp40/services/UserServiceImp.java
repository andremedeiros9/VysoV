package org.academiadecodigo.bootcamp40.services;

import org.academiadecodigo.bootcamp40.dto.UserDto;
import org.academiadecodigo.bootcamp40.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp40.persistence.dao.jpa.ChallengeJpaDao;
import org.academiadecodigo.bootcamp40.persistence.dao.jpa.UserJpaDao;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp {

    private UserJpaDao userJpaDao;
    private ChallengeServiceImp challengeServiceImp;
    private ChallengeJpaDao challengeJpaDao;

    @Autowired
    public void setUserJpaDao(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }

    @Autowired
    public ChallengeServiceImp getChallengeServiceImp() {
        return challengeServiceImp;
    }

    @Autowired
    public ChallengeJpaDao getChallengeJpaDao() {
        return challengeJpaDao;
    }

    @Transactional(readOnly = true)
    public User getById(Integer id){
        return userJpaDao.findById(id);
    }

    public Challenge getNewChallenge(User user){
        int challengeId = challengeServiceImp.getRandomChallenge(user.getLevel());
        return challengeServiceImp.getById(challengeId);
    }

    @Transactional
    public void completedChallenge(Integer id, Challenge challenge) {
        User user = userJpaDao.findById(id);
        user.addChallenge(challenge);
    }

    @Transactional
    public List<Challenge> getMyChallenges(Integer id) {
        User user = userJpaDao.findById(id);
        return user.getChallenges();
    }

    @Transactional
    public User save(User user){
        user.setLevel();
        userJpaDao.saveOrUpdate(user);

        return user;
    }

}
