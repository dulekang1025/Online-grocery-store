package com.pika.Onlinegrocerystore.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
public class Customer implements UserDetails {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private final String password;

    private final String name;

    private String email;

    private String role;

    private Date birthday;

    private String address;

    private String postcode;

    private Long creditNum;

    private final String phoneNum;

    private String points;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(("ROLE_USER")));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
