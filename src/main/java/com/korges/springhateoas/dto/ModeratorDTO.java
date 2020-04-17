package com.korges.springhateoas.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
public class ModeratorDTO extends RepresentationModel<ModeratorDTO> {
    private Long id;
    private String nickname;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;
}
