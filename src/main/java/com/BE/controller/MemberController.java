package com.BE.controller;

import com.BE.model.entity.Member;
import com.BE.model.request.MemberRequest;
import com.BE.service.MemberService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/members")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody MemberRequest memberRequest) {
        Member newMember = memberService.create(memberRequest);
        return ResponseEntity.ok(newMember);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody MemberRequest memberRequest) {
        Member updatedMember = memberService.update(id, memberRequest);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        Member deletedMember = memberService.delete(id);
        return ResponseEntity.ok(deletedMember);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getMemberById(@PathVariable UUID id) {
        Member member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }
}