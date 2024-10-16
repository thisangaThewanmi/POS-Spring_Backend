package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemCartDto {
    private int id;
    private String orderId;
    private String itemCode;
    private String itemName;
    private int qty;  // Quantity of items
    private BigDecimal price;  // Price of the item
    private BigDecimal total;

}
