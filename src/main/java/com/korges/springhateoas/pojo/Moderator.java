package com.korges.springhateoas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Moderator extends RepresentationModel<Moderator> implements Serializable {
    private Long id;
    private String nickname;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;
}
