package com.korges.springhateoas.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String nickname;
    private String email;
    private LocalDate registrationDate;
    private Set<Post> postSet;
    private Set<Thread> threadSet;
}
