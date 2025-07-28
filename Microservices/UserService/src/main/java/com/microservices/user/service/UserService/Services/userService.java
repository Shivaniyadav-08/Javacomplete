package com.microservices.user.service.UserService.Services;

import com.microservices.user.service.UserService.entity.UsersData;

import java.util.List;

public interface userService {

    UsersData saveUser(UsersData users);

    List<UsersData> getAll ();

    UsersData getByID(int id);

    UsersData updateUser(UsersData users);

    void delete(int id);
}
