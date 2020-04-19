package com.korges.springhateoas.service.post;

import com.korges.springhateoas.controller.post.PostResource;
import com.korges.springhateoas.entity.Post;

import java.util.Set;

public interface PostService {
    Set<PostResource> findAll();
    PostResource findById(Long id);
    PostResource deleteById(Long id);
    PostResource save(Post post);
}
