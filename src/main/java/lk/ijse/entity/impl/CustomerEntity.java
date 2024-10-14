package lk.ijse.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="customer")
public class CustomerEntity {


    @Id
    private String id;
    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    //1 customerta orders gdk nisa list ekaka



}
