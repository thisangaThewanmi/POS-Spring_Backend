package lk.ijse.service;

import jakarta.transaction.Transactional;
import lk.ijse.dao.OrderDao;
import lk.ijse.dto.OrderDto;
import lk.ijse.dto.OrderStatus;
import lk.ijse.entity.impl.OrderEntity;
import lk.ijse.exception.DataPersistException;
import lk.ijse.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderDao orderDao;

    @Autowired
    Mapping orderMapping;


    @Override
    public void saveOrder(OrderDto orderDto) {
        OrderEntity savedOrder = orderDao.save(orderMapping.toOrderEntity(orderDto));

        if (savedOrder == null) {
            throw new DataPersistException("Order not saved");
        }
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return  orderMapping.asOrderDTOList(orderDao.findAll());

    }

    @Override
    public OrderStatus getOrder(String orderId) {
        return null;
    }
}