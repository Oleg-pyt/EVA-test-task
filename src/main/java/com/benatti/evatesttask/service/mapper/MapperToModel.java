package com.benatti.evatesttask.service.mapper;

public interface MapperToModel<M, D> {
    M matToModel(D requestDto);
}
