package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="cart")
@Getter@Setter
@ToString//(exclude = "member")
public class Cart extends BaseEntity {  // 공통 멤버변수 상속

    @Id  // 기본키로 지정
    @Column(name="cart_id")  // 테이블 이름(필드명) 사용자 지정  없으면 그냥 동일하게 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    Entity에서 특정 Entity를 참조할 경우 반드시 연관관계 어노테이션을 적용 (fetch설정은 안해도 상관없음. 기본값 EAGER)
    - 장바구니가 엔티티가 회원엔티티를 참조하는 형태: 장바구니(외래키), 회원(참조:기본키)
    - FetchType.EAGER( 즉시조인, 기본값으로 설정 되어 있음), FetchType.Lazy(필요할 때 조인)
    eager: 열렬한,열심인 lazy: 게으른 :b
    LAZY설정을 안하면 해당필드가 불려올 때마다 관련된 것도 다 불려옴
     */

    // member_id 필드를 외래키(FK)로 설정
    @OneToOne(fetch = FetchType.LAZY)  // 1:1 연관관계 어노테이션 // LAZY설정을 안하면 해당필드가 불려올 때마다 관련된 것도 다 불려옴
    // @JoinColumn(name="테이블 필드명") 테이블에 해당 필드명을 가진 필드를 조인시킴.  필드명이 일치해야함.
    @JoinColumn(name="member_id")  // 맵핑할 외래키(FK) 설정
    // Member를 불러오면 기본키(ID)로 설정된 값 이 불려옴 참조 Member.java
    private Member member;  // private Long member_id 인식

    // 회원 장바구니 생성하는 메서드
    // 회원 1명당 1개의 장바구니 멥핑
    public static Cart createCart(Member member) {

        Cart cart = new Cart();
        cart.setMember(member);

        return cart;
    }

}

/*
cart:item (1:N)  item:cart (1:N)
연관 관계가 서로 얽혀있을 경우 관계를 바로 쓸 수 없음 (애초에 말도 안됨)

위 관계를 구현하기 위해 중계자(cartItem)를 사용.
cartItem은 cart정보와 item정보 둘다 가지고 있음.
cart:cartItem(1:N), cartItem:item(N:1)  =>  cart:cartItem:item (1:N:1)


 */
/*
 * @OneToOne
 *
 * Cart             <->     Member
 * cart_id(PK)      1:1     member_id(PK)
 * member_id(FK)            name, email, password, address, role ...
 *
 */
