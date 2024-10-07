package com.BE.model.response;

import com.BE.enums.RoleEnum;
import com.BE.enums.StatusEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class AdminResponse {
    private UUID id;
    private String username;
    private String email;
    private RoleEnum role;
    private StatusEnum status;
    private Boolean isDelete;
    // Remove the authorities field
}
