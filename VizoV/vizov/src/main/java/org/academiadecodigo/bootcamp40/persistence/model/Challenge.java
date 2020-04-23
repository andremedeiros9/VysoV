package org.academiadecodigo.bootcamp40.persistence.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "challenges")
public class Challenge extends AbstractModel {

    private int level;
    private String title;
    private String description;


    @ManyToMany(
            mappedBy = "challenges",
            fetch = FetchType.EAGER
    )
    private List<User> users = new ArrayList<User>();

    public int getLevel() {
        return level;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
       users.add(user);
    }
}
