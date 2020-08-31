package com.pika.Onlinegrocerystore.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@RequiredArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final Long id;

    private Long userId;
    private double sumPrice;

    @OneToMany(targetEntity = Product.class)
    private Map<Product, Integer> goods;


}
