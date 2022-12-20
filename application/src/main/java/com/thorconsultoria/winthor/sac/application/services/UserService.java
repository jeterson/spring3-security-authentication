package com.thorconsultoria.winthor.sac.application.services;

import com.thorconsultoria.winthor.sac.application.entities.User;
import com.thorconsultoria.winthor.sac.application.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User findByUsername(String username) {
       var user = userRepository.findByUsername(username);

       if(user.isPresent()) {
           return user.get();
       }
       return null;
    }

    public String encodePassword(String rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
}
