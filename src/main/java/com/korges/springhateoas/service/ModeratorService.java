package com.korges.springhateoas.service;

import com.korges.springhateoas.dto.ModeratorDTO;
import com.korges.springhateoas.entity.Moderator;

import java.util.Set;

public interface ModeratorService {
    Set<ModeratorDTO> findAll();
    ModeratorDTO findById(Long id);
    ModeratorDTO addNewModerator(Moderator moderator);
    void deleteById(long id);
}
