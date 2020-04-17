package com.korges.springhateoas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Moderator {
    private Long id;
    private String nickname;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;
}
