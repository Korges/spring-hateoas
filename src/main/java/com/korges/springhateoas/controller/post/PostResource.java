package com.korges.springhateoas.controller.post;

import com.korges.springhateoas.controller.thread.ForumThreadController;
import com.korges.springhateoas.entity.Post;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
public class PostResource extends RepresentationModel<PostResource> {

    private final Post post;

    public PostResource(Post post) {
        this.post = post;
        this.add(linkTo(ForumThreadController.class).slash(post.getId()).withSelfRel());
    }
}
