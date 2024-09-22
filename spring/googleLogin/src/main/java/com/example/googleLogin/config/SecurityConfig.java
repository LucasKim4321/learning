package com.example.googleLogin.config;

import com.example.googleLogin.constant.Role;
import com.example.googleLogin.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(
                        (csrfConfig) -> csrfConfig.disable()
                )
                .formLogin(login -> {
                    login.loginPage("/mylogin")             // 로그인 처리할 url 설정
                        .defaultSuccessUrl("/")                   // 로그인 성공시 url 설정
//                        .usernameParameter("email")               // 웹의 username의  매개변수이름 설정
//                        .passwordParameter("password")            // 웹의 password의  매개변수이름 설정
                        //.loginProcessingUrl("/members/login")   // 웹 로그인창의 form action값 설정
                        .failureUrl("/");  // 로그인 실패시 url 설정
                })
                            .headers(
                        (headerConfig) -> headerConfig.frameOptions(
                                frameOptionsConfig -> frameOptionsConfig.disable()
                        )
                )
                .authorizeHttpRequests((authorizeRequest) -> authorizeRequest
                        .requestMatchers("/posts/new", "/comments/save").hasRole(Role.USER.name())
                        .requestMatchers("/", "/css/**", "images/**", "/js/**", "/mylogin", "/login/*", "/logout/*", "/posts/**", "/comments/**").permitAll()
                        .anyRequest().authenticated()
                )
                .logout( // 로그아웃 성공 시 / 주소로 이동
                        (logoutConfig) -> logoutConfig.logoutSuccessUrl("/")
                )
                // OAuth2 로그인 기능에 대한 여러 설정
//                .oauth2Login(Customizer.withDefaults()); // 아래 코드와 동일한 결과
                .oauth2Login(
                        (oauth) ->
                            oauth.userInfoEndpoint(
                                    (endpoint) -> endpoint.userService(customOAuth2UserService)
                            )
                );

        return http.build();
    }
}