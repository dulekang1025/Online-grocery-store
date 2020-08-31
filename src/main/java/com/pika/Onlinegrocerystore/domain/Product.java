package com.pika.Onlinegrocerystore.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.sql.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int Stock;
    private String productName;
    private Category Category;
    private double price;

    // unit
    private String productDescription;
    private Image productPhoto;
    private int points;
    private Date bestBefore;

}
