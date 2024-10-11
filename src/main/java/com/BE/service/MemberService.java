package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Member;
import com.BE.model.request.MemberRequest;
import com.BE.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member create(MemberRequest memberRequest) {
        Member member = new Member();
        member.setFullName(memberRequest.getFullName());
        member.setEmail(memberRequest.getEmail());
        member.setUsername(memberRequest.getUsername());
        member.setPassword(memberRequest.getPassword());
        member.setRank(memberRequest.getRank());
        member.setPoints(memberRequest.getPoints());
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member update(UUID id, MemberRequest memberRequest) {
        Member existingMember = getMemberById(id);
        existingMember.setFullName(memberRequest.getFullName());
        existingMember.setEmail(memberRequest.getEmail());
        existingMember.setUsername(memberRequest.getUsername());
        existingMember.setPassword(memberRequest.getPassword());
        existingMember.setRank(memberRequest.getRank());
        existingMember.setPoints(memberRequest.getPoints());
        return memberRepository.save(existingMember);
    }

    public Member delete(UUID id) {
        Member existingMember = getMemberById(id);
        existingMember.setDeleted(true);
        return memberRepository.save(existingMember);
    }

    public Member getMemberById(UUID id) {
        return memberRepository.findById(id).orElseThrow(() -> new NotFoundException("Member not found"));
    }
}