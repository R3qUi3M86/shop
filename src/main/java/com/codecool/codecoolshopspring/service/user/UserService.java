package com.codecool.codecoolshopspring.service.user;

import com.codecool.codecoolshopspring.model.user.User;
import com.codecool.codecoolshopspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetails = userRepository.findByUsername(username);
        return userDetails.orElseThrow(() -> new UsernameNotFoundException("User: "+username+" Not found"));
    }

    public void putNewUser(User user){
        userRepository.save(user);
    }
}
