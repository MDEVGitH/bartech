package com.bartech.auth_service.controller;

import static java.util.Objects.isNull;

import com.bartech.auth_service.dto.AuthUserDto;
import com.bartech.auth_service.dto.TokenDto;
import com.bartech.auth_service.entity.AuthUser;
import com.bartech.auth_service.service.AuthUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/V1")
@CrossOrigin(origins = "*")
public class AuthUserController {

    @Autowired
    AuthUserService authUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto dto) {
        TokenDto tokenDto = authUserService.login(dto);
        if(tokenDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam("token") String token) {
        TokenDto tokenDto = authUserService.validate(token);
        if(isNull(tokenDto)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody AuthUserDto dto) {
        AuthUser authUser = authUserService.save(dto);
        if(authUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(authUser);
    }
}
