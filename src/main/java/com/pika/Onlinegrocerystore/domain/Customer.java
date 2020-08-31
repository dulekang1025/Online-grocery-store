package com.pika.Onlinegrocerystore.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@RequiredArgsConstructor
public class Customer implements UserDetails {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private final String password;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private final String username;

    private String email;

    // can be instead by getAuthorities()
    private String role;

    private Date birthday;

//    private String address;

//    private String postcode;

//    private String creditNum;

    private final String phoneNum;

    private int points;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(("ROLE_USER")));
    }

//    @Override
//    public String getPassword() {
//        return null;
//    }

//    @Override
//    public String getUsername() {
//        return null;
//    }

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
