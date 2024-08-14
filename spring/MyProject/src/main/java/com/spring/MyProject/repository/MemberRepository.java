package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

// Member에 대한 JpaRepository
public interface MemberRepository extends JpaRepository<Member, Long> {  // JpaRepository<엔티티명, 엔티티의 기본키명>

    // public 생략하면 기본값 default 패키지 내에서 공유
//    Member findByEmail(String email);

    // 지연로딩시 적용 : 쿼리실행시 proxy객체 생성하여 proxy객체 호출시에만 수행
    @EntityGraph(attributePaths = "roleSet")
    Member findByEmail(String email);

}
