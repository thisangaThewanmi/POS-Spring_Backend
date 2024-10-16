package lk.ijse.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

        @Id
        private String orderId;
        private String orderDate;



        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customerId", nullable = false)
        private CustomerEntity customer;
        //eka order ekakata 1 customere kenk nisa 1 entity ekakk

        private String customerName;
        private BigDecimal total;
        private BigDecimal discount;
        private BigDecimal subtotal;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "order_item",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "item_code")
        )
        private List <ItemEntity> items;
    }

