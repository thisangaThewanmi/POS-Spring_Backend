package lk.ijse.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

        @Id
        private String orderId;
        private LocalDate orderDate;
        private Double total;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customer_id", nullable = false)
        private CustomerEntity customer;
        //eka order ekakata 1 customere kenk nisa 1 entity ekakk

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "order_item",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "item_code")
        )
        private List <ItemEntity> items;
    }

