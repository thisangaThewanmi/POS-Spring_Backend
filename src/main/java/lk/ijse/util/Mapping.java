package lk.ijse.util;

import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemCartDto;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.OrderDto;
import lk.ijse.entity.impl.CustomerEntity;
import lk.ijse.entity.impl.ItemEntity;
import lk.ijse.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //for user mapping
    public CustomerEntity toCustomerEntity (CustomerDto customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public CustomerDto toCustomerDto(CustomerEntity customerEntity ) {
        return modelMapper.map(customerEntity, CustomerDto.class);
    }
    public List<CustomerDto> asUserDTOList(List<CustomerEntity > customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDto>>() {}.getType());
    }


    public ItemEntity toItemEntity (ItemDto itemDto) {

        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto toItemDto(ItemEntity itemEntity ) {

        return modelMapper.map(itemEntity, ItemDto.class);
    }
    public List<ItemDto> asItemDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDto>>() {}.getType());
    }


    //for orders
    public OrderDto toOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDto.class);
    }
    public OrderEntity toOrderEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderEntity.class);
    }
    public List<OrderDto> asOrderDTOList(List<OrderEntity> orderEntities) {
        return modelMapper.map(orderEntities, new TypeToken<List<OrderDto>>() {}.getType());
    }

}
