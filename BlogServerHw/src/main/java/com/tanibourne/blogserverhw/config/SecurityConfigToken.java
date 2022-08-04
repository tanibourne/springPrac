package com.tanibourne.blogserverhw.config;

import com.tanibourne.blogserverhw.filter.JwtAuthenticationFilterToken;
import com.tanibourne.blogserverhw.filter.JwtAuthorizationFilterToken;
import com.tanibourne.blogserverhw.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;
@Profile("token")
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigToken {
    private final CorsFilter corsFilter;
    private final MemberRepository memberRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable(); // csrf 필터를 disable 함
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilter(corsFilter)
                .formLogin().disable() // form Login을 사용하지 않음
                // http 통신 : headers에 Authorization 값을 ID, Password를 입력하는 방식 (JWT에서 사용하지 않음)
                // https를 사용하면 ID와 Password가 암호화되어 전달
                .httpBasic().disable()
                .apply(new CustomDsl());

        return http.build();
    }
    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

        //해당 필터에는 AuthenticationManager가 필요하여 별도의 class로 만듦
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder.addFilter(corsFilter)
                    .addFilter(new JwtAuthenticationFilterToken(authenticationManager))
                    .addFilter(new JwtAuthorizationFilterToken(authenticationManager, memberRepository));
        }

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
