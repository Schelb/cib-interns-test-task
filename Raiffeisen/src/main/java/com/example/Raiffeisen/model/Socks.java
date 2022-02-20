package com.example.Raiffeisen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String color;
    private int cottonPart;
    private int quantityPairs;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantityPairs() {return quantityPairs;}

    public void setQuantityPairs(int quantityPairs) {this.quantityPairs = quantityPairs;}

    public Socks(String color, int cottonPart , int quantityPairs){
        this.color= color;
        this.cottonPart= cottonPart;
        this.quantityPairs=quantityPairs;
    }
    public Socks(){
    }
}
