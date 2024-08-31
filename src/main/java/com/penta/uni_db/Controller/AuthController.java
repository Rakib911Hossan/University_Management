package com.penta.uni_db.Controller;


import com.penta.uni_db.Dto.AuthResponseDto;
import com.penta.uni_db.Dto.LoginDto;
import com.penta.uni_db.Dto.RegisterDto;
import com.penta.uni_db.Repository.RoleRepo;
import com.penta.uni_db.Repository.UserRepo;
import com.penta.uni_db.SecurityConfig.JWTGenerator;
import com.penta.uni_db.models.Role;
import com.penta.uni_db.models.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Component
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager, UserRepo userRepo, RoleRepo roleRepo,
                          PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication=authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
    }


    @PostMapping("register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterDto registerDto){
    if(userRepo.existsByUsername(registerDto.getUsername())){
        return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
    }
        UserEntity user=new UserEntity();
    user.setUsername(registerDto.getUsername());
    user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role roles= roleRepo.findByName("ADMIN").get();
        user.setRoles(Collections.singletonList(roles));

        userRepo.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("register/teacher")
    public ResponseEntity<String> registerTeacher(@RequestBody RegisterDto registerDto){
       if(userRepo.existsByUsername(registerDto.getUsername())){
           return new ResponseEntity<>("Username already taken",HttpStatus.BAD_REQUEST);
       }

       UserEntity user=new UserEntity();
       user.setUsername(registerDto.getUsername());
       user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

       Role roles=roleRepo.findByName("TEACHER").get();
       user.setRoles(Collections.singletonList(roles));

       userRepo.save(user);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("register/student")
    public ResponseEntity<String> registerStudent(@RequestBody RegisterDto registerDto){
        if (userRepo.existsByUsername(registerDto.getUsername())){
            return new ResponseEntity<>("User already taken",HttpStatus.BAD_REQUEST);
        }

        UserEntity user=new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role roles=roleRepo.findByName("STUDENT").get();
        user.setRoles(Collections.singletonList(roles));

        userRepo.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
