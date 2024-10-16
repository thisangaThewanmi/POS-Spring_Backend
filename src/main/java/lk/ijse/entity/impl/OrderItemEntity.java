/*
package lk.ijse.entity.impl;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "orderItem")
    public class OrderItemEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id; // Optional id for the join table

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id", referencedColumnName = "orderId")
        private OrderEntity order;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "item_code", referencedColumnName = "code")
        private ItemEntity item;

        // Additional fields for the join table
        @Column(name = "quantity")
        private int quantity;  // The quantity of items in the order

        @Column(name = "price")
        private BigDecimal price;  // Price per item

        @Column(name = "total")
        private BigDecimal total;  // Total cost for the item in the order

        // You can add more fields here as needed (e.g., discount, tax, etc.)
    }


*/
