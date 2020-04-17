package com.korges.springhateoas.controller;

import com.korges.springhateoas.dto.ModeratorDTO;
import com.korges.springhateoas.entity.Moderator;
import com.korges.springhateoas.service.ModeratorService;
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
@RequestMapping("/admin")
public class AdminController {

    private final ModeratorService moderatorService;

    @GetMapping
    public ResponseEntity<CollectionModel<ModeratorDTO>> findAllModerators() {
        Link link = linkTo(AdminController.class).withSelfRel();
        final Set<ModeratorDTO> response = moderatorService.findAll();
        response.forEach(x -> x.add(linkTo(AdminController.class).slash(x.getId()).withSelfRel()));
        CollectionModel<ModeratorDTO> model = new CollectionModel<>(response, link);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ModeratorDTO>> findModeratorById(@PathVariable("id") long id) {
        Link link = linkTo(AdminController.class).slash(id).withSelfRel();
        ModeratorDTO response = moderatorService.findById(id);
        EntityModel<ModeratorDTO> model = new EntityModel<>(response, link);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntityModel<String>> deleteModerator(@PathVariable("id") long id) {
        Link link = linkTo(AdminController.class).slash(id).withSelfRel();
        moderatorService.deleteById(id);
        EntityModel<String> model = new EntityModel<>("Moderator Deleted", link);
        return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ModeratorDTO>> addNewModerator(@RequestBody Moderator moderator) {
        Link link = linkTo(AdminController.class).withSelfRel();
        ModeratorDTO response = moderatorService.addNewModerator(moderator);
        EntityModel<ModeratorDTO> model = new EntityModel<>(response, link);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
