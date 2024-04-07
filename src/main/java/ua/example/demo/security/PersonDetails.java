package ua.example.demo.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.example.demo.models.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Getter
public class PersonDetails implements UserDetails {

    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//мы здесь будем получать роли и будем возвращать список прав
        //SHOW_ACCOUNT, WITHDRAW_MONEY, SEND_MONEY
        //ROLE_ADMIN, ROLE_USER -
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getName();
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

//этот аккаунт включен, он работает:
    @Override
    public boolean isEnabled() {
        return true;
    }

}
