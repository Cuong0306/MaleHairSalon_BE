package com.BE.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginRequestDTO {
    private String username;
    private String password;
}
