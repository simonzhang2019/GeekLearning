package com.simon.user.controller;

import com.simon.user.entity.ShoppingUser;
import com.simon.user.service.ShoppingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ShoppingUserService userService;

    @GetMapping("/tryPayment/{id}")
    public int tryPayment(@PathVariable long id){
        ShoppingUser user = new ShoppingUser();
        user.setId(id);
        user.setStatus(0);
        return userService.tryPayment(user);
    }

}
