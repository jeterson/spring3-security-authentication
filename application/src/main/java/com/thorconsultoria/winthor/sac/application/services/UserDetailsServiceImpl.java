package com.thorconsultoria.winthor.sac.application.services;

import com.thorconsultoria.winthor.sac.application.config.security.UserDetailsData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userService.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found with username " + username);

        user.setPassword(userService.encodePassword(user.getPassword()));
        return new UserDetailsData(user);

    }
}
