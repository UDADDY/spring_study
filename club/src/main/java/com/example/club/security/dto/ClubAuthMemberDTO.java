package com.example.club.security.dto;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
public class ClubAuthMemberDTO extends User {

    private String email;
    private String name;
    private boolean fromSocial;

    public ClubAuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
    }
}
