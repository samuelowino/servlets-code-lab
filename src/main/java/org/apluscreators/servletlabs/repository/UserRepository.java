package org.apluscreators.servletlabs.repository;

import org.apluscreators.servletlabs.model.User;

import java.util.UUID;

public class UserRepository {

    public User getUser(){
        return new User(UUID.randomUUID().toString(),"Samuel Kool joh","1234567");
    }
}
