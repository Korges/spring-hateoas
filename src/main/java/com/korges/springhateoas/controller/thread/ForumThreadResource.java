package com.korges.springhateoas.controller.thread;

import com.korges.springhateoas.entity.ForumThread;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
public class ForumThreadResource extends RepresentationModel<ForumThreadResource> {

    private final ForumThread thread;

    public ForumThreadResource(ForumThread thread) {
        this.thread = thread;
        this.add(linkTo(ForumThreadController.class).slash(thread.getId()).withSelfRel());
    }
}
