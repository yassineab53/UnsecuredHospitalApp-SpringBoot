package net.yassine.hospitalapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //creer les utilisateurs qui ont le droit d'acceder à l'application
    // on va creer un objet de type InMemoryUserDetailsManager
    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager{
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password("1234").roles("USER").build(),
                User.withUsername("user2").password("1234").roles("USER").build(),
                User.withUsername("admin").password("1234").roles("USER", "ADMIN").build()
        );
    }*/
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password("password").roles("USER").build(),
                User.withUsername("user2").password("1234").roles("USER").build(),
                User.withUsername("admin").password("1234").roles("USER", "ADMIN").build()
        );
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin();
        // dire à Spring Security je voudrais que toutes les requetes necessitent une authentification
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        return httpSecurity.build();
    }
}
