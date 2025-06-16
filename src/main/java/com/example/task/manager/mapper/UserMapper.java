package com.example.task.manager.mapper;

import com.example.task.manager.dal.entity.UserEntity;
import com.example.task.manager.dto.CreateUserRequest;
import com.example.task.manager.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", constant = "USER")
    UserEntity map(CreateUserRequest request);

    List<UserDto> map(List<UserEntity> entity);

}
