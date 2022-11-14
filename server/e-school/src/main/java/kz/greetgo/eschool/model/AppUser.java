package kz.greetgo.eschool.model;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.List;

@Data
public class AppUser implements UserDetails {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private final List<SimpleGrantedAuthority> authorities;

    public AppUser(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("REGISTERED"));
    }
    @Override
    public String getUsername() {
        return userName;
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
