package com.BE.mapper;


import com.BE.model.entity.User;
import com.BE.model.request.AdminRequest;
import com.BE.model.response.AdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    // Map AdminRequest to User
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.BE.enums.RoleEnum.valueOf(request.getRole().toUpperCase()))")
    User toUser(AdminRequest request);

    //Map User to AdminResponse
    AdminResponse toAdminResponse(User user);

    // Update existing User with AdminRequest
    void updateUser(@MappingTarget User user, AdminRequest request);
}

