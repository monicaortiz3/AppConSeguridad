package com.data.dataWarehouse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
       return http.authorizeHttpRequests(auth -> auth
                       .requestMatchers("/api/v1/protegido/**").authenticated()
                       .requestMatchers("/api/v1/clientes").authenticated()
                       .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                //.formLogin(Customizer.withDefaults()) aparece una pagina por default
               .formLogin(AbstractHttpConfigurer::disable)
                .build();
    }
    /* @Bean
    public InMemoryUserDetailsManager userInMemory(){
        UserDetails dam = User.withUsername("Dam").password("Dam").roles("ADMIN").build();
        UserDetails vane = User.withUsername("Vane").password("Vane").roles("ADMIN").build();
        UserDetails jere = User.withUsername("Jere").password("Jere").roles("USER").build();
        return new InMemoryUserDetailsManager(dam,vane,jere);
    }

     */


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
