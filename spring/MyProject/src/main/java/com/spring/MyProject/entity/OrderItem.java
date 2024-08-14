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
