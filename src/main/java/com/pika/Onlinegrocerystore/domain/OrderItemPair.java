package com.pika.Onlinegrocerystore.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@AllArgsConstructor
public class OrderItemPair {

    @Id
    private Long orderId;

    @Id
    private Long productId;

    private int quantity;

}
