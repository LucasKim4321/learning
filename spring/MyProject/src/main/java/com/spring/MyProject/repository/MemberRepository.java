package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // public 생략하면 기본값 default 패키지 내에서 공유
    Member findByEmail(String email);
}
