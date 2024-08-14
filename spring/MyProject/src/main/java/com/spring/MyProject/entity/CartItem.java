package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name="cart_item")
public class CartItem extends BaseEntity {

    @Id
    @Column(name= "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // strategy:계획
    private Long id;

    // 연관관계  cart:cartItem:item(1:N:1) => cart:cartItem(1:N), cartItem:item(N:1)
    // cartItem이 N  cart,item은 1이고 cartItem 입장에서 쓰니 둘 다 @ManyToOne으로 설정
    
    // 하나의 장바구니는 여러개의 상품과 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Cart cart;
    // 하나의 상품은 여러개의 장바구니와 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    private int count;

}
