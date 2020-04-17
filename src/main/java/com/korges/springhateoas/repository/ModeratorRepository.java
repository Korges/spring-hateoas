package com.korges.springhateoas.repository;

import com.korges.springhateoas.entity.Moderator;

import java.util.Set;

public interface ModeratorRepository {
    Set<Moderator> findAll();
    Moderator findById(Long id);
    Moderator save(Moderator moderator);
    void deleteById(long id);
}
