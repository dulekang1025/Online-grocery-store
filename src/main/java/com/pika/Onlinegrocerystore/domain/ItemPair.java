package com.pika.Onlinegrocerystore.domain;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@AllArgsConstructor
public class ItemPair {
    private Long cartId;
    private Long productId;
    private int quantity;
}
