
package com.pika.Onlinegrocerystore.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long cartId;

    private Long userId;
    private double sumPrice;

//    @OneToMany(targetEntity = Product.class)
//    private Map<Product, Integer> productMap;
}

