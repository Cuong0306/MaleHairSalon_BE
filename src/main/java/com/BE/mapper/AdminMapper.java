package com.BE.mapper;


import com.BE.model.entity.Admin;
import com.BE.model.entity.User;
import com.BE.model.request.AdminRequest;
import com.BE.model.response.AdminResponse;
import com.BE.model.response.AuthenticationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    // Map AdminRequest to Admin
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.BE.enums.RoleEnum.valueOf(request.getRole().toUpperCase()))")
    @Mapping(target = "isDelete", ignore = true) // Ignore is_delete when mapping from AdminRequest to Admin
    Admin toAdmin(AdminRequest request);

    // Map Admin to AdminResponse
    AdminResponse toAdminResponse(Admin admin);

    // Map User to AdminResponse
    AdminResponse toAdminResponse(User user);

    // Update existing Admin with AdminRequest
    void updateAdmin(@MappingTarget Admin admin, AdminRequest request);

    AuthenticationResponse toAuthenticationResponse(Admin admin);
}

