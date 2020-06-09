package com.lucine.api.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getUserById(Long id){
        return repository.findById(id).get();
    }

    public User createUser(User user){
        return repository.save(user);
    }

    public User updateUser(Long id, User user){
        User userToUpdate = repository.findById(id).get();
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setMail(user.getMail());
        return repository.save(userToUpdate);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
        return;
    }


    /*public User authUser(String userLogin) {
        return this.repository.authUser(userLogin);
    }*/

}

