package com.spring.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String orderName;


    @Column(name = "price")
    private int price;


    @Column(name = "image")
    private String img;

    @Column(name = "description")
    @Lob  // to set big size to write description because default size 256 character
    private String description;

    @Column(name = "date_create")
    @CreationTimestamp
    private Date dateCreate;

    @Column(name = "date_update")
    @UpdateTimestamp
    private Date dateUpdate;

    @JsonIgnore  //to avoid the list of older name of problem circle
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
