package com.tanibourne.blogserverhw.repository;

import com.tanibourne.blogserverhw.models.Feed;
import com.tanibourne.blogserverhw.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    public Member findByNickname(String member);

}
