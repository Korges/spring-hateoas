package com.korges.springhateoas.service.thread;

import com.korges.springhateoas.controller.post.PostResource;
import com.korges.springhateoas.controller.thread.ForumThreadResource;
import com.korges.springhateoas.entity.ForumThread;
import com.korges.springhateoas.repository.ForumThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ForumThreadServiceImpl implements ForumThreadService {
    private final ForumThreadRepository forumThreadRepository;

    @Override
    public Set<ForumThreadResource> findAll() {
        return forumThreadRepository
                .findAll()
                .stream()
                .map(ForumThreadResource::new)
                .collect(Collectors.toSet());
    }

    @Override
    public ForumThreadResource findById(Long id) {
        return forumThreadRepository
                .findById(id)
                .map(ForumThreadResource::new)
                .orElseThrow(PropertyNotFoundException::new);
    }

    @Override
    public Set<PostResource> findAllPostsByThread(Long id) {
         return forumThreadRepository
                 .findById(id)
                 .map(x -> x.getPostSet()
                         .stream()
                         .map(PostResource::new)
                         .collect(Collectors.toSet()))
                 .orElseThrow(PropertyNotFoundException::new);
    }

    @Override
    public ForumThreadResource save(ForumThread thread) {
        return new ForumThreadResource(forumThreadRepository.save(thread));
    }

    @Override
    public ForumThreadResource update(Long id, ForumThread thread) {
        thread.setId(id);
        return forumThreadRepository
                .findById(id)
                .map(x -> thread)
                .map(forumThreadRepository::save)
                .map(ForumThreadResource::new)
                .orElseThrow(PropertyNotFoundException::new);
    }

    @Override
    public ForumThreadResource deleteById(Long id) {
        return forumThreadRepository
                .findById(id)
                .map(x -> {
                    forumThreadRepository.delete(x);
                    return new ForumThreadResource(x);
                })
                .orElseThrow(PropertyNotFoundException::new);
    }
}
