package com.project.SpringSecurity.Service;

import com.project.SpringSecurity.Repo.Userrepo;
import com.project.SpringSecurity.model.UserPrinciple;
import com.project.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class myUserService implements UserDetailsService {
    @Autowired
   private Userrepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userrepo.findByUsername(username);
        if(users==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(users);
    }


}
