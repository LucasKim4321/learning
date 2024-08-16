package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
//@Table(name="order_item")  // 생략시 이름 자동 생성
public class OrderItem extends BaseEntity {  // 주문 작성일, 주문 수정일 상속받음

    @Id
    @Column(name="order_item_id")
    @GeneratedValue
    private Long id;

    // item:orderitem:order(1:n:1)
    // orderitem N  order,item은 1이고 orderitem 입장에서 쓰니 둘 다 @ManyToOne으로 설정

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    // 주문 작성일, 주문 수정일 상속받음

}


/*  다대일, 일대다 양방향 맵핑
주문서 -> 1명의 회원이 여러개의 주문서를 연결

orders                    order_item                item
----------------------------------------------------------------------------------------------
order_id(PK)              order_item_id(PK)         item_id(PK)
member_id(FK),            order_id(FK)              item_name,...
                          item_id(FK)               order_price, count,....
                          order_date,..

// 주문A-> 상품1,상품2(1:N) ,   상품1-> A주문,B주문 (1:M)
Order_item_id       order_id        item_id
1                   A               상품1
2                   A               상품2
3                   B               상품1
4                   B               상품2
5                   B               상품3

 */
