package lk.ijse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDto implements ItemStatus{

        private String code;
        private String name;
        private Double price;
        private int qty;
        private List<OrderDto> orders;
}
