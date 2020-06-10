package com.lucine.api.webservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService service;

    @GetMapping()
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Long id){
        service.deleteUser(id);
        return true;
    }

     /*@GetMapping("/userAuth")
    public User authUser(@RequestBody String userLogin) {
        return this.service.authUser(userLogin);
    }

     */

}
