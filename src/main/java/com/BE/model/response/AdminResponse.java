package com.BE.model.response;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AdminResponse {
    private UUID id;
    private String fullName;
    private String email;
    private String username;
    private String role;
}
