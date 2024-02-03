package com.WebGameProject.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http.csrf((csrf) -> csrf.disable())
         .cors((cors) -> cors.disable())
         .authorizeHttpRequests(request -> request
            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            .requestMatchers("/", "/css/**", "/js/**", "/img/**").permitAll()
            .requestMatchers("/guest/**").permitAll()
            .requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()      //어떠한 요청이라도 인증필요
            );
      
      http.formLogin((formLogin) ->
                  formLogin.permitAll());      //기본 로그인 페이지
      http.logout((logout) ->
                    logout.permitAll());         //로그아웃 기본설정(/logout으로
      return http.build();
   }
   
   @Bean
   public UserDetailsService users() {
      UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("1234"))
            .roles("USER")      //ROLE_USER 에서 ROLE_는 자동으로 붙는다.
            .build();
      UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("1234"))
            .roles("USER","ADMIN")
            .build();
      
      return new InMemoryUserDetailsManager(user, admin);
   }
   
   public PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
   }
}