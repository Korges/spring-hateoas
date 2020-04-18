package com.korges.springhateoas.dto;

import com.korges.springhateoas.entity.Post;
import com.korges.springhateoas.entity.Thread;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.Set;

@Data
public class UserDTO extends RepresentationModel<UserDTO> {
    private Long id;
    private String nickname;
    private String email;
    private LocalDate registrationDate;
    private Set<Post> postSet;
    private Set<Thread> threadSet;
}
