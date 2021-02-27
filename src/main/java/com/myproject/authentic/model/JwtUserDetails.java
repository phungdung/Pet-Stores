package com.myproject.authentic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myproject.data.dto.ManagerDTO;
import com.myproject.data.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class JwtUserDetails implements UserDetails {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(Long id, String email, String password,
                          Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public JwtUserDetails(long id, String email, String password, String token,
                          List<GrantedAuthority> grantedAuthorities) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.token = token;
        this.authorities = grantedAuthorities;
    }

    public static JwtUserDetails build(ManagerDTO managerDTO) {
        List<GrantedAuthority> authorities = managerDTO.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());

        return new JwtUserDetails(
                managerDTO.getManagerId(),
                managerDTO.getEmail(),
                managerDTO.getPassword(),
                authorities);
    }

    public static JwtUserDetails build(MemberDTO memberDTO) {
        List<GrantedAuthority> authorities = memberDTO.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());

        return new JwtUserDetails(
                memberDTO.getUserId(),
                memberDTO.getEmail(),
                memberDTO.getPassword(),
                authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
