package lk.ijse.service;

import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.CustomerStatus;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.ItemStatus;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDto itemDto);
    List<ItemDto> getAllItems();
    ItemStatus getItems(String itemId);
    void deleteItem(String itemId);
    void updateItem(String itemId, ItemDto itemDto);
}
