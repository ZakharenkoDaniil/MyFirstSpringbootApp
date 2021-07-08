package org.example.RESTonSpringBoot.Controllers;


import org.example.RESTonSpringBoot.Entity.User;
import org.example.RESTonSpringBoot.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId).toString();
    }

    @PostMapping("/user")
    public String postUser(@RequestBody User user){
        boolean result = userService.createUser(user);
        if(result){
            return "successfully post "+user.toString();
        }
        return "posting error";
    }

    @PutMapping("/user/{userId}")
    public String putUser(@PathVariable("userId") Long userId, @RequestBody User user){
        boolean result = userService.updateUser(userId, user);
        if(result){
            return "successfully put";
        }
        return "puting error";
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        boolean result = userService.deleteUser(userId);
        if(result){
            return "successfully delete";
        }
        return "deleting error";
    }

}
