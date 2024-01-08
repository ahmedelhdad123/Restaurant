package com.spring.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image")
    private String img;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
