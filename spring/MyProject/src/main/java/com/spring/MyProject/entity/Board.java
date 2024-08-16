package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

// Entity 정의 : 테이블에 적용될 구조설계 정의하여 테이블과 entity 1:1 맵핑
@Entity@Table(name="Board")  // name을 따로 설정하지 않으면 자동으로 엔티티명과 동일한 이름의 테이블을 만듬
@Getter@Setter
@ToString//(exclude = "imageSet")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board extends BaseEntity{  //extends BaseEntity 하면 BaseEntity에 있는 변수 여기에 추가

    @Id  // 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)  // length = (max = 16383)
    private String content;
    @Column(length = 50, nullable = false)
    private String writer;

    // 현재 로그인 사용자와 게시글 작성자가 동일한지 판별하기 위한 항목
    private String email;

    // 데이터 수정하는 메서드
    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 첨부파일
    // 1. mappedBy속성, cascade:상위엔티티가 하위에티티를 관리,@OneToMany(생략시FetchType.LAZY설정됨)
    //  - 외래키가 아닌 엔티티를 주인(주체)로 설정 할 경우 => Board Entity 멤버변수(속성)로 연관관계 설정이 아닌 경우
    //  - 어떤 엔티티의 속성으로 매핑할 경우 => imageSet.order속성으로 연관관계 설정
    //  -  @OneToMany => FetchType.LAZY 기본값으로 설정됨.

    // 2. 고아객체
    // => 부모엔티티와 연관관계가 끊어진 자식엔티티
    // 고아객체 제거 : orphanRemoval 속성 이용
    // @OneToOne, @OneToMany에 사용

    // 3. 'N+1'로 실행되는 쿼리는 DB를 많이 사용하는 단점 => @BatchSize어노테이션 활용
    // 'N번'에 해당하는 쿼리를 모아서 한번에 실행
    // ~~ board_bno in (?,?,?,...) 형식으로
    // 지정된 수만큼 BoardImage를 조회할 때 한번에 in조건으로 사용
    @OneToMany(mappedBy = "board",
            cascade = {CascadeType.ALL},  // 두개 이상 설정 시 {}
            fetch = FetchType.LAZY,  // LAZY속성 때문에 imageSet값을 읽어올때 에러남.
            orphanRemoval = true)  // 고아객체 발생시 자동 삭제  // 옵션 넣기 전 기존의 고아 객체들한텐 발동안함
    @Builder.Default
    @BatchSize(size=20)  // 20개를 한번에 검색
    private Set<BoardImage> imageSet = new HashSet<>();

    // Board 객체에서 BoardImage 엔티티는 별도의 JPARepository를 생성하지 않아도
    // 상위엔티티(Board)에서 하위엔티티(BoardImage)객체를 관리하는 기능 추가해서 사용.

    // Board 객체에서 BoardImage객체를 관리하도록 하기 위해
    // addImage(), clearImage() 작성
    public void addImage(String uuid, String fileName) {
        
        // 상위 엔티티에서 하위 엔티티 생성
        BoardImage boardImage = BoardImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .board(this)
                .ord(imageSet.size())
                .build();

        // 첨부파일 생성하여 Set 추가
        imageSet.add(boardImage);
    }

    // 삭제 처리 기능
    public void clearImage(){
        imageSet.forEach( boardImg -> boardImg.changeBoard(null));
        this.imageSet.clear(); // boardImage객체 데이터 삭제
    }

}

/*
 * 스프링 계층 구조
 *
 * 1. 프레젠테이션 계층 (컨트롤러)
 *  - HTTP요청을 받고 이 요청을 비즈니스 계층으로 전송하는 역할
 *
 * 2. 비즈니스 계층 (서비스)
 *  - 모든 비즈니스 로직 처리 (서비스를 만들기 위한 로직)
 *
 * 3. 퍼시스턴스 계층 (리포지토리):Entity가 작업대상
 *  - 모든 데이터베이스 관련 로직을 처리
 * 
 * 4. 데이터베이스 (database)
 *  - 엔티티와 1:1 맵핑된 테이블은 실제 DB작업을 반영
 */
