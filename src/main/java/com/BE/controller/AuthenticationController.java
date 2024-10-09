package com.BE.controller;


import com.BE.model.entity.User;
import com.BE.model.request.*;
import com.BE.model.response.AuthenticationResponse;
import com.BE.service.AuthenticationService;
import com.BE.service.JWTService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@SecurityRequirement(name ="api")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody AuthenticationRequest user){
        return ResponseEntity.ok(authenticationService.register(user));
    }
    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authenticationService.authenticate(loginRequestDTO));
    }

    @PostMapping("/login-google")
    private ResponseEntity checkLoginGoogle(@RequestBody LoginGoogleRequest loginGGRequest){
        return ResponseEntity.ok(authenticationService.loginGoogle(loginGGRequest));
    }

    @PostMapping("forgot-password")
    public ResponseEntity forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        authenticationService.forgotPasswordRequest(forgotPasswordRequest.getEmail());
        return ResponseEntity.ok( "Forgot Password successfully");
    }

    @PatchMapping("reset-password")
    public ResponseEntity resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        authenticationService.resetPassword(resetPasswordRequest);
        return ResponseEntity.ok( "Reset Password successfully");
    }

    @GetMapping("/testRole")
    public ResponseEntity testRole(){
        return ResponseEntity.ok("Test Role User Successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-only")
    public ResponseEntity admin(){
        return ResponseEntity.ok(authenticationService.admin());
    }

    @PatchMapping("/status")
    public ResponseEntity status(@Valid @RequestBody StatusRequest statusRequest) {
        return ResponseEntity.ok(statusRequest.getStatus());
    }






}
