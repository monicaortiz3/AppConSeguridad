package com.data.dataWarehouse.security;

import com.data.dataWarehouse.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MiUserDetails implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public MiUserDetails(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("USUARIO RECIBIDO: " + username);

        return usuarioRepository.findByNombre(username)
                .map(usuario -> {
                    System.out.println("USUARIO ENCONTRADO: " + usuario.getNombre());
                    System.out.println("CONTRASEÑA BD: " + usuario.getContrasenia());

                    return new User(
                            usuario.getNombre(),
                            usuario.getContrasenia(),
                            Collections.emptyList()
                    );
                })
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado"));
    }
}

