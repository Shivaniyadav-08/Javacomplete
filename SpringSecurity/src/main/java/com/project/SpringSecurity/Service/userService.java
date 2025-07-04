package com.project.SpringSecurity.Service;

import com.project.SpringSecurity.Repo.Userrepo;
import com.project.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
     private Userrepo userrepo;

    @Autowired
    private JWTservice jwTservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users register(Users users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userrepo.save(users);

    }


    public String verify(Users users) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));

        if(authentication.isAuthenticated()){
            return jwTservice.generateToken(users.getUsername());
        }else{
            return "Fail";
        }
    }
}