package com.example.GoCafe.service;

import com.example.GoCafe.entity.Member;
import com.example.GoCafe.repository.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member m = memberRepository.findByMemberEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        String role = (m.getMemberRole() == null || m.getMemberRole().isBlank()) ? "USER" : m.getMemberRole();
        if (!role.startsWith("ROLE_")) role = "ROLE_" + role;

        return User.withUsername(m.getMemberEmail())
                .password(m.getMemberPassword())
                .authorities(List.of(new SimpleGrantedAuthority(role)))
                .build();
    }
}
