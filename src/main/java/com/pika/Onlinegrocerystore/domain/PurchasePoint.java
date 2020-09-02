package com.pika.Onlinegrocerystore.domain;

public class PurchasePoint {
    private Long userId;
    private int points;
    
    public PurchasePoint(Long userId, int points){
        this.userId = userId;
        this.points = points;
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
