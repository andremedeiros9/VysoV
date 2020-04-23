package org.academiadecodigo.bootcamp40.persistence.dao.jpa;

import org.academiadecodigo.bootcamp40.persistence.dao.ChallengeDao;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.springframework.stereotype.Repository;

@Repository
public class ChallengeJpaDao extends GenericJpaDao<Challenge> implements ChallengeDao {

    public ChallengeJpaDao() {
        super(Challenge.class);
    }

}
