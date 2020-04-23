package org.academiadecodigo.bootcamp40.persistence.dao.jpa;

import org.academiadecodigo.bootcamp40.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaDao extends GenericJpaDao<User> implements UserDao {

    public UserJpaDao() {
        super(User.class);
    }

}
