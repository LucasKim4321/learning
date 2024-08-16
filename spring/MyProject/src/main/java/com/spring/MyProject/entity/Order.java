package com.spring.MyProject.entity;

import com.spring.MyProject.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="orders") // "order" 단어는 DB에서 이미사용되는 키워드
@Getter@Setter
//@ToString//(exclude = "member")
public class Order extends BaseEntity{  // 주문 작성일, 주문 수정일 상속받음



    @Id  // 기본키로 지정
    @Column(name="order_id")  // 테이블 이름(필드명) 사용자 지정  없으면 그냥 동일하게 설정
    @GeneratedValue  // 기본값 설정  (strategy = GenerationType.IDENTITY)생략
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")  // FK 설정
    private Member member;  // 1명의 회원은 여러개의 주문서를 연결

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;  // 주문상태 (주문, 취소)
    private LocalDateTime orderDate;  // 주문 일자

    // 주문 작성일, 주문 수정일 상속받음

    // 주문 상품 맵핑
    // 외래키(order_id)가 order_item 테이블에 있으며, 연관 관계의 OrderItem 엔티티가 주체임
    // Order엔티티가 주인(주체)이 아니므로 "mappedBy"속성으로 연관 관계의 주인을 설정
    // OrderItem에 있는 Order에 의해 관리된다는 의미

    // 외래키가 아닌 엔티티를 주인(주체)로 설정 할 경우
    // => Order의 멤버변수(속성)로 연관관계 설정이 아닌 경우
    // 어떤 엔티티의 속성으로 매핑할 경우
    // cascade = CascadeType.ALL 영속성 전이. order 엔티티를 수정,삭제 등을 하면 orderitem 엔티티도 같이 수정, 삭제 됨
    // @OneToMany => FetchType.LAZY 기본값으로 설정됨.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @ToString.Exclude  // "order"는 orderitem의 order를 참조함
    private List<OrderItem> orderItems = new ArrayList<>();

}


/*  다대일, 일대다 양방향 맵핑
주문서 -> 1명의 회원이 여러개의 주문서를 연결

member                        orders                    order_item
--------------------------------------------------------------------
member_id(PK)                 order_id(PK)              order_item_id(PK)
name, email,...               member_id(FK),            order_id(FK)
                              order_date,..             item_id(FK)
                                                        order_price, count,....

   orders
   -------
   order_id(PK)
   member_id(FK)
   order_date,...

    order_item_id(PK), order_id(FK),item_id(FK), order_price,...



- 연관관계의 주인은 외래키가 있는 곳으로 설정
- 연관 관계의 주인이 외래키를 관리(등록, 수정, 삭제)

- 주인이 아닌쪽(외래키(FK)가 아닌쪽)은 연관 관계 매핑시 mappedBy 속성의 값으로 연관관계의 주인을 설정
- 주인이 아니 쪽은 읽기만 가능

영속성 전이: 상위엔티티가 하위엔티티 객체를 관리
CASCADE
상위요소의 변화에 따라 하위요소도 변함

CASCADE종류

PERSIST   부모 엔티티가 영속화 될 때 자식 엔티티도 영속화
MERGE
REMOVE    부모 엔티티가 삭제 될 때 연관된 자식 엔티티도 삭제
REFRESH
DETACH
ALL     부모 엔티티의 영속성 상태변화를 자식 엔티티에 모두 전이

- 고객이 주문할 상품을 선택하고 주문할 때 주문 엔티티를 저장하면서 주문 상품 엔티티도 함께 저장되는 경우

 */