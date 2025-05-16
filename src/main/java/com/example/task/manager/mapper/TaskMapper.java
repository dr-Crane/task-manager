package com.example.task.manager.mapper;

import com.example.task.manager.dal.Feature;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import org.mapstruct.*;

import java.time.Instant;

@Mapper(
        componentModel = "spring",
        imports = Instant.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TaskMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    @Mapping(target = "status", constant = "NEW")
    Task mapForCreate(Integer id, CreateUpdateTaskDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    @Mapping(target = "status", constant = "NEW")
    Feature mapForCreateFeature(Integer id, CreateUpdateTaskDto dto);

    void mapForUpdate(@MappingTarget Task task, CreateUpdateTaskDto dto);

}
