package com.korges.springhateoas.dto;

import com.korges.springhateoas.entity.Post;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ThreadDTO extends RepresentationModel<ThreadDTO> {
    private Long id;
    private LocalDate creationDate;
    private Set<Post> postSet;
}
