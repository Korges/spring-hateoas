package com.korges.springhateoas.service.post;

import com.korges.springhateoas.controller.post.PostResource;
import com.korges.springhateoas.entity.Post;
import com.korges.springhateoas.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Set<PostResource> findAll() {
        return postRepository
                .findAll()
                .stream()
                .map(PostResource::new)
                .collect(Collectors.toSet());
    }

    @Override
    public PostResource findById(Long id) {
        return postRepository
                .findById(id)
                .map(PostResource::new)
                .orElseThrow(PropertyNotFoundException::new);
    }

    @Override
    public PostResource save(Post post) {
        return new PostResource(postRepository.save(post));
    }

    @Override
    public PostResource deleteById(Long id) {
        return postRepository
                .findById(id)
                .map(x -> {
                    postRepository.delete(x);
                    return new PostResource(x);
                })
                .orElseThrow(PropertyNotFoundException::new);
    }
}
