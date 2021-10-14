package com.vklonin.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Post  {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2, message="Name should have at least 2 characters")
    private  String description;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
