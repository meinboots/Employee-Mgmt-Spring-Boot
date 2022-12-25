package com.mutantbikers.springbootdemo.controller;

import com.mutantbikers.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class homeController {

    @RequestMapping("/")
    public String greeting(){
        return "Hello from spring controller !";
    }

    @GetMapping("/users")
    public User user(){
        User user = new User();

        //Setting Values
        user.setId(1);
        user.setName("Coolguy");
        user.setEmailId("coolguy@duck.com");
        return user;
    }

    @GetMapping("/{val_1}/{other}")
    public String pathVariable(@PathVariable String val_1,
                            @PathVariable("other") String val_2){ // Put other's value in val_2
        return "Your values are : " +val_1 + ", another :  " +val_2;
    }

    @GetMapping("/reqparam")
    public String requestParam(@RequestParam String name){
        return "Your name is : " +name;
    }
}
