package com.tanibourne.blogserverhw.filter;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanibourne.blogserverhw.models.Member;
import com.tanibourne.blogserverhw.oauth.PrincipalDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Profile("token")
@RequiredArgsConstructor
public class JwtAuthenticationFilterToken extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("### login 시도 ###");

        try {

            ObjectMapper om = new ObjectMapper();
            Member member = om.readValue(request.getInputStream(), Member.class);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(member.getNickname(), member.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken); // 인증 절차 실행
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal(); // 생략 가능 (principal을 가져옴)
            return authentication;

        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override // 정상처리 했을 때 실행하는 메서드
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        System.out.println("### successful Authentication ###");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal(); // 정보를 가져옴

        String jwtToken = JWT.create()
                .withSubject("cos jwt token")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 1000 * 10))) // 10분
                .withClaim("id", principalDetails.getMember().getId()) // Claim : payload 에 있는 값 비교
                .withClaim("username", principalDetails.getMember().getNickname())
                .sign(Algorithm.HMAC512("cos_jwt_token")); // 정보들을 암호화할 방식 및 salt
        response.addHeader("Authorization", "Bearer " + jwtToken); // 헤더에 이름 추가
    }
}