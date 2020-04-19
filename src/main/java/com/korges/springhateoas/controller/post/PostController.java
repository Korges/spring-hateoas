package com.korges.springhateoas.controller.post;

import com.korges.springhateoas.entity.Post;
import com.korges.springhateoas.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<CollectionModel<PostResource>> findAllPost() {
        final Set<PostResource> response = postService.findAll();
        Link link = linkTo(PostController.class).withSelfRel();
        final CollectionModel<PostResource> resource = new CollectionModel<>(response, link);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PostResource>> findOneById(@PathVariable final Long id) {
        final PostResource response = postService.findById(id);
        final EntityModel<PostResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityModel<PostResource>> postNewThread(@RequestBody final Post post) {
        final PostResource response = postService.save(post);
        final EntityModel<PostResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntityModel<PostResource>> deletePost(@PathVariable final Long id) {
        final PostResource response = postService.deleteById(id);
        final EntityModel<PostResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
