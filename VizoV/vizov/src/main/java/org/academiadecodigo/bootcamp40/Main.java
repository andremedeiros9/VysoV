package org.academiadecodigo.bootcamp40;

import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setUserName("Andre");
        user.setEmail("andre1991medeiros@gmail.com");

        UserServiceImp userServiceImp = new UserServiceImp();

        System.out.println(userServiceImp.getNewChallenge(user));

    }
}
