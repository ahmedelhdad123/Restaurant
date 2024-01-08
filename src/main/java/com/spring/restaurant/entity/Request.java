package com.spring.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Lob // can replace @lob with length =
    @Column(name = "note")
    private String notes;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date_create")
    @CreationTimestamp
    private Date dateCreate;

    @Column(name = "date_update")
    @UpdateTimestamp
    private Date dateUpdate;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "request")
    private List<Items> items=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address=new Address();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client=new Client();

    public void addItem(Items item)
    {
        items.add(item);
        item.setRequest(this);
    }

}
