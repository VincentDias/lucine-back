package com.lucine.api.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired UserService service;

    @GetMapping()
    public List<User> getAll() {
        return this.service.getAll();
    }

    @PostMapping()
    public User authUser(@RequestBody String userLogin) {
        return this.service.authUser(userLogin);
    }

}
