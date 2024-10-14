package lk.ijse.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")

public class ItemEntity {

        @Id
        private String code;
        private String name;
        private Double price;
        private String qty;
        @ManyToMany(mappedBy = "items")
        private List<Order> orders;

    }

