package com.project.SpringSecurity.Controller;


import com.project.SpringSecurity.Service.userService;
import com.project.SpringSecurity.model.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private userService userService;


// register data
    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return userService.register(users) ;
    }


}
