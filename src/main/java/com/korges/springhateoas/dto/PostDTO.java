package com.korges.springhateoas.dto;

import com.korges.springhateoas.entity.Post;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

public class PostDTO extends RepresentationModel<PostDTO> {
    private Long id;
    private String message;
    private LocalDate creationDate;
}
