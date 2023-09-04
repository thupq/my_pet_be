package com.thupq.mypets.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    default List<E> toEntity(List<D> dtoList){
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<D> toDto(List<E> entityList){
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}
