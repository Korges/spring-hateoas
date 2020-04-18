package com.korges.springhateoas.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class Thread {
    private Long id;
    private LocalDate creationDate;
    private Set<Post> postSet;
}
