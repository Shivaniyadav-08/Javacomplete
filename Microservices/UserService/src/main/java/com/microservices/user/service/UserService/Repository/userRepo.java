package com.microservices.user.service.UserService.Repository;

import com.microservices.user.service.UserService.entity.UsersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<UsersData,Integer> {

}
