package org.academiadecodigo.bootcamp40.dto;

import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.persistence.model.LevelType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Integer id;
    @NotNull
    @NotBlank
    private String userName;
    private String email;
    private LevelType level;
    private String password;
    private List<Challenge> challenges = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public LevelType getLevel() {
        return level;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
