package com.tanibourne.blogserverhw.config;

import com.tanibourne.blogserverhw.filter.FirstFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Profile("bearer")
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfigBearer {
    private final CorsFilter corsFilter;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        return (web) -> web.ignoring()
                .antMatchers("/h2-console/**","/favicon.ico");
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
        http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class);

        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        //corsFilter 추가
                        .and().addFilter(corsFilter)
                        //formLogin 사용 안함
                        .formLogin().disable()
                        //http 통신을 할 때 headers에 Authorization 값을 ID, Password를 입력하는 방식 (사용 안함)
                        .httpBasic().disable();




//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .antMatchers("/user/**").permitAll()
//                        .antMatchers("**").permitAll()
//                        .antMatchers("/").permitAll()
//                        .antMatchers(HttpMethod.GET,"/api/feeds").permitAll()
//                        .antMatchers(HttpMethod.GET, "/api/reply/**").permitAll()
//                        .anyRequest().authenticated());
//
//        // [로그인 기능]

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }




}