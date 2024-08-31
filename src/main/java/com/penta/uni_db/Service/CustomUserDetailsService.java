package com.penta.uni_db.Service;


import com.penta.uni_db.Repository.UserRepo;
import com.penta.uni_db.models.Role;
import com.penta.uni_db.models.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Username no found"));
        return new User(user.getUsername(),
                user.getPassword(),mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().
                map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}