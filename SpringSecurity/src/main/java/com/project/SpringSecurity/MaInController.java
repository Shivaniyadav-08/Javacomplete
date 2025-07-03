package com.project.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MaInController {

    @GetMapping("")
    public String greet(HttpServletRequest request){
        return ("Hello I'm working!!"+ request.getSession().getId());
    }
}
