package com.spring.restaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String roles;

//    @Column(name = "active")
//    private int active;
//
//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role"
//    ,joinColumns = {@JoinColumn(name = "user_id")}
//    ,inverseJoinColumns = {@JoinColumn(name = "authorities")}
//    )
//    private List<Authorities> authoritiesList=new ArrayList<>();
}
