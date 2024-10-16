package lk.ijse.service;

import lk.ijse.dto.OrderDto;
import lk.ijse.dto.OrderStatus;

import java.util.List;


public interface OrderService {

    void saveOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
    OrderStatus getOrder(String orderId);
}
