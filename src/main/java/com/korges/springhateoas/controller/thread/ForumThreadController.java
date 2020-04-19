package com.korges.springhateoas.controller.thread;

import com.korges.springhateoas.controller.post.PostResource;
import com.korges.springhateoas.entity.ForumThread;
import com.korges.springhateoas.service.thread.ForumThreadService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
@RequestMapping("/thread")
public class ForumThreadController {

    private final ForumThreadService forumThreadService;

    @GetMapping
    public ResponseEntity<CollectionModel<ForumThreadResource>> findAllThread() {
        final Set<ForumThreadResource> response = forumThreadService.findAll();
        Link link = linkTo(ForumThreadController.class).withSelfRel();
        final CollectionModel<ForumThreadResource> resource = new CollectionModel<>(response, link);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ForumThreadResource>> findOneById(@PathVariable final Long id) {
        final ForumThreadResource response = forumThreadService.findById(id);
        response.add(linkTo(methodOn(ForumThreadController.class).findThreadPosts(id)).withRel("posts"));
        final EntityModel<ForumThreadResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @GetMapping("/{id}/post")
    public ResponseEntity<CollectionModel<PostResource>> findThreadPosts(@PathVariable final Long id) {
        final Set<PostResource> response = forumThreadService.findAllPostsByThread(id);
        Link link = linkTo(ForumThreadController.class).withSelfRel();
        final CollectionModel<PostResource> resource = new CollectionModel<>(response, link);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ForumThreadResource>> postNewThread(@RequestBody final ForumThread thread) {
        final ForumThreadResource response = forumThreadService.save(thread);
        final EntityModel<ForumThreadResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ForumThreadResource>> updateThread(@PathVariable final Long id,
                                                                         @RequestBody final ForumThread thread) {
        final ForumThreadResource response = forumThreadService.update(id, thread);
        final EntityModel<ForumThreadResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntityModel<ForumThreadResource>> deleteThread(@PathVariable final Long id) {
        final ForumThreadResource response = forumThreadService.deleteById(id);
        final EntityModel<ForumThreadResource> resource = new EntityModel<>(response);

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
