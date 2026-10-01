package com.example.eventpassutec.Config;

import com.example.eventpassutec.Security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.servlet.FilterChain;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tools.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final ObjectMapper objectMapper;
    public SecurityConfig(JwtAuthFilter jwtauthfilter, ObjectMapper objectMapper) {
        this.jwtAuthFilter = jwtauthfilter;
        this.objectMapper = objectMapper;
    }

    @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.POST, "/auth/register", "auth/login").permitAll().requestMatchers(HttpMethod.GET, "/events", "/events/*").permitAll().requestMatchers(HttpMethod.POST, "/events").hasRole("ORGANIZER").requestMatchers(HttpMethod.PUT, "/events/*").hasRole("ORGANIZER").requestMatchers(HttpMethod.DELETE, "/events/*").hasRole("ORGANIZER").requestMatchers(HttpMethod.POST, "/events/*/tickets").hasRole("ORGANIZER").anyRequest().authenticated()).exceptionHandling(h->h.authenticationEntryPoint(authenticationEntryPoint()).accessDeniedHandler(accesDeniedHandler())).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, e) -> {
            response.setStatus(401);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            objectMapper.writeValue(response.getWriter(), ApiError.of(401, "Se requiere un toker jwt valido"));
        }
    }

    @Bean
    public AuthenticationEntryPoint accessDeniedHandler() {
        return (request, response, e) -> {
            response.setStatus(403);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            objectMapper.writeValue(response.getWriter(), ApiError.of(403, "No tiene permisos para esta operacion"));
        }
    }
}
