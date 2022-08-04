package com.tanibourne.blogserverhw.oauth;

import com.tanibourne.blogserverhw.oauth.PrincipalDetails;
import com.tanibourne.blogserverhw.models.Member;
import com.tanibourne.blogserverhw.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Profile({"login", "token"})
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private  final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByNickname(username);

        return new PrincipalDetails(member);
    }
}
