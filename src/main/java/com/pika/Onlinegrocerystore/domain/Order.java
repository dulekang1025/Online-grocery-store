package com.pika.Onlinegrocerystore.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

@Entity
@Data
@Table(name="Your_Order") //todo: will be changed when finish service layer
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @ManyToOne
    private Customer userId;

    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="State is required")
    private String state;

    @NotBlank(message="City is required")
    private String city;

    @NotBlank(message="Street is required")
    private String street;

    @NotBlank(message="Zip code is required")
    private String zip;

    @CreditCardNumber(message="Not a valid credit card number") //4916467436125138
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

//    private String trackingNum;
    private Double sumPrice;
//    private Date createTime;


    private OrderStatus status;

    private int earnPoints;

    @ManyToMany(targetEntity = Product.class)
    private Map<Product, Integer> orderDetails;

}
