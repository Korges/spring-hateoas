package com.korges.springhateoas.controller.thread;

import com.korges.springhateoas.entity.ForumThread;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@RequiredArgsConstructor
public class ForumThreadResource extends RepresentationModel<ForumThreadResource> {

    private final ForumThread thread;
}
