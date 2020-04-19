package com.korges.springhateoas.service.thread;

import com.korges.springhateoas.controller.thread.ForumThreadResource;
import com.korges.springhateoas.entity.ForumThread;

import java.util.Set;


public interface ForumThreadService {

    Set<ForumThreadResource> findAll();
    ForumThreadResource findById(Long id);
    ForumThreadResource save(ForumThread thread);
    ForumThreadResource update(Long id, ForumThread thread);
    ForumThreadResource deleteById(Long id);
}
