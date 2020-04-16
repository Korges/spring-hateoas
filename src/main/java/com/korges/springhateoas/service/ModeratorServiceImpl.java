package com.korges.springhateoas.service;

import com.korges.springhateoas.pojo.Moderator;
import com.korges.springhateoas.repository.ModeratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ModeratorServiceImpl implements ModeratorService {

    private final ModeratorRepository moderatorRepository;

    @Override
    public Set<Moderator> findAll() {
        return moderatorRepository.findAll();
    }

    @Override
    public Moderator findById(Long id) {
        return moderatorRepository.findById(id);
    }

    @Override
    public Moderator addNewModerator(Moderator moderator) {
        return moderatorRepository.save(moderator);
    }
}
