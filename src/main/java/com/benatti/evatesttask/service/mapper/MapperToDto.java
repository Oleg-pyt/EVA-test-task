package com.benatti.evatesttask.service.mapper;

public interface MapperToDto<M, D> {
    D mapToDto(M model);
}
