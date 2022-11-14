package kz.greetgo.eschool.config.Security;

import kz.greetgo.eschool.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserServiceImpl userService;
    @Autowired
    public UserDetailsServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final UserDetails user = userService.findByUserName(userName);
        if(user.equals(null)){
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return user;

    }
}

