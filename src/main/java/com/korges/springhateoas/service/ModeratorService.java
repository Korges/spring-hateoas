package com.korges.springhateoas.service;

import com.korges.springhateoas.pojo.Moderator;

import java.util.Set;

public interface ModeratorService {
    Set<Moderator> findAll();
    Moderator findById(Long id);
    Moderator addNewModerator(Moderator moderator);
}
