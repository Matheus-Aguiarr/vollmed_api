package com.vollmed.apirest.domain.usuario.repository;

import com.vollmed.apirest.domain.usuario.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByLogin(String login);
}
