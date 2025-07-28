package com.microservices.user.service.UserService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UsersData")
public class UsersData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private  String email;
    private  String about;

    @Transient
    private List<Rating> ratingList = new ArrayList<>();

}
