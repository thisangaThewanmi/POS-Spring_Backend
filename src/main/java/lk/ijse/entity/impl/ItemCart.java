package lk.ijse.entity.impl;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity

    public class ItemCart {

         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private int id;


        @Column(name = "order_id", nullable = false)
        private String orderId;

        @Column(name = "item_code", nullable = false)
        private String itemCode;

        @Column(name = "item_name", nullable = false)
        private String itemName;

        @Column(name = "quantity", nullable = false)
        private int qty;

        @Column(name = "price", nullable = false)
        private BigDecimal price;

        @Column(name = "total", nullable = false)
        private BigDecimal total;

    }
