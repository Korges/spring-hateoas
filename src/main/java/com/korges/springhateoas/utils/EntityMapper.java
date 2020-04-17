package com.korges.springhateoas.utils;

import com.korges.springhateoas.dto.ModeratorDTO;
import com.korges.springhateoas.entity.Moderator;
import org.mapstruct.Mapper;

import java.util.Set;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper( componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface EntityMapper {

    ModeratorDTO moderatorToModeratorDTO(Moderator moderator);
    Set<ModeratorDTO> moderatorListToModeratorDTOList(Set<Moderator> moderatorList);

}
