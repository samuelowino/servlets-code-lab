package org.apluscreators.servletlabs.service;

import org.apluscreators.servletlabs.model.User;
import org.apluscreators.servletlabs.repository.UserRepository;

public class UsersService {

    UserRepository userRepository;

    public UsersService(){
        this.userRepository = new UserRepository();
    }

    public User getUser(){
        return userRepository.getUser();
    }
}
