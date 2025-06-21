package com.vollmed.apirest.controllers;

import com.vollmed.apirest.domain.usuario.UsuarioModel;
import com.vollmed.apirest.dtos.usuario.AuthDTO;
import com.vollmed.apirest.infra.security.TokenJwtDTO;
import com.vollmed.apirest.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((UsuarioModel) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }
}
