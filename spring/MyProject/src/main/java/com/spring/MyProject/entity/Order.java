package com.spring.MyProject.entity;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @Column(name= "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
