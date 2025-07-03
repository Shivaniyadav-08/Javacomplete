package com.project.SpringSecurity.Service;

import com.project.SpringSecurity.Repo.Userrepo;
import com.project.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
     private Userrepo userrepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users register(Users users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userrepo.save(users);

    }


}