package com.korges.springhateoas.service;

import com.korges.springhateoas.dto.ModeratorDTO;
import com.korges.springhateoas.entity.Moderator;
import com.korges.springhateoas.repository.ModeratorRepository;
import com.korges.springhateoas.utils.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ModeratorServiceImpl implements ModeratorService {

    private final EntityMapper mapper;
    private final ModeratorRepository moderatorRepository;

    @Override
    public Set<ModeratorDTO> findAll() {
        return mapper.moderatorListToModeratorDTOList(moderatorRepository.findAll());
    }

    @Override
    public ModeratorDTO findById(Long id) {
        return mapper.moderatorToModeratorDTO(moderatorRepository.findById(id));
    }

    @Override
    public ModeratorDTO addNewModerator(Moderator moderator) {
        return mapper.moderatorToModeratorDTO(moderatorRepository.save(moderator));
    }

    @Override
    public void deleteById(long id) {
        this.moderatorRepository.deleteById(id);
    }
}
