package com.pika.Onlinegrocerystore.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int inStock;
    private String productName;
//    private Category category;
    private int categoryId;
    private double price;
    //todo Category类和Image类在productMapper.xml中可能需要改

    // unit
    private String productDescription;
    private Image productPhoto;
    private int points;
    private Date bestBefore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryNum() {
        return categoryId;
    }

    public void setCategoryNum(int categoryNum) {
        this.categoryId = categoryNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Image getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(Image productPhoto) {
        this.productPhoto = productPhoto;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(Date bestBefore) {
        this.bestBefore = bestBefore;
    }
}
