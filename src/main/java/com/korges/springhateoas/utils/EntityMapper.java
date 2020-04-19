package com.korges.springhateoas.utils;

import org.mapstruct.Mapper;

import java.util.Set;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper( componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface EntityMapper {


}
