package com.lucine.api.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired UserService service;

    @GetMapping()
    @CrossOrigin
    public List<User> getAll() {
        return service.getAll();
    }


}
