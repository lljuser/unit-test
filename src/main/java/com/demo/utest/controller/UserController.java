package com.demo.utest.controller;

import com.demo.utest.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping("/getname")
    public String  getName(){
        return "llj";
    }

    @PostMapping("/getuser")
    public User getUser(User user){
        return user;
    }

    @PostMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user=new User();
        user.setId(id);
        user.setAge(110);
        user.setName("llj");
        user.setAddress("sh");
        return user;
    }
}
