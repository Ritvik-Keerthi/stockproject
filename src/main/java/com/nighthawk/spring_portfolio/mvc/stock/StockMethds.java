package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class StockMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    public Stock() {
    }

    public Stock(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
