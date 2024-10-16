package lk.ijse.dto;

import jakarta.persistence.*;
import lk.ijse.entity.impl.CustomerEntity;
import lk.ijse.entity.impl.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private String orderId;
    private String orderDate;
    private String customerId;
   /* private String customerName;*/
    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal subtotal;
    private List<ItemEntity> items;
}
