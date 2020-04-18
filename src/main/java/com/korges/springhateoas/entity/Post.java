package com.korges.springhateoas.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {
    private Long id;
    private String message;
    private LocalDate creationDate;
}
