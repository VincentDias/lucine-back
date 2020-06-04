package com.lucine.api.webservices.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository repository;

    public UserService() {
        this.repository  = new UserRepository();
    }

    public List<User> getAll() {
        return this.repository.findAll();
    }

    public User authUser(String userLogin) {
        return this.repository.authUser(userLogin);
    }

}
