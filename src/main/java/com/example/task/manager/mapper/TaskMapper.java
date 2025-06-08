package com.example.task.manager.mapper;

import com.example.task.manager.dal.entity.TaskEntity;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.Instant;

@Mapper(
        componentModel = "spring",
        imports = Instant.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "NEW")
    TaskEntity mapForCreate(CreateUpdateTaskDto dto);

    void mapForUpdate(@MappingTarget TaskEntity entity, CreateUpdateTaskDto dto);

    TaskDto map(TaskEntity entity);

}
