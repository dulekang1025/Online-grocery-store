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

    private String phoneNum;

    private int points;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public String getPhoneNum() {
//        return phoneNum;
//    }
//
//    public int getPoints() {
//        return points;
//    }

    // 加了构造方法就不报错了, for testing
    public Customer(Long id, String username, String password, String email, String role, Date birthday, String phoneNum) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
    }

    // Override constructor, no id, for testing
    public Customer(String username, String password, String email, String role, Date birthday, String phoneNum) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(("ROLE_USER")));
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
