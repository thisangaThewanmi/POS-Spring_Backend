package lk.ijse.service;

import jakarta.transaction.Transactional;
import lk.ijse.customStatusCodes.SelectedCustomerErrorStatus;
import lk.ijse.customStatusCodes.SelectedItemErrorStatus;
import lk.ijse.dao.ItemDao;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.ItemStatus;
import lk.ijse.entity.impl.CustomerEntity;
import lk.ijse.entity.impl.ItemEntity;
import lk.ijse.exception.CustomerNotFoundException;
import lk.ijse.exception.DataPersistException;
import lk.ijse.util.AppUtil;
import lk.ijse.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemDao itemDao;

    @Autowired
    Mapping itemMapping;

    @Override
    public void saveItem(ItemDto itemDto) {

        itemDto.setCode(AppUtil.generateItemId());

        ItemEntity savedItem = itemDao.save(itemMapping.toItemEntity(itemDto));

        if(savedItem == null) {
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public List<ItemDto> getAllItems() {

        return  itemMapping.asItemDTOList(itemDao.findAll());
    }

    @Override
    public ItemStatus getItems(String itemId) {

        System.out.println("ItemId: " + itemId);

        boolean flag= itemDao.existsById(itemId);
        System.out.println("itemsExsistsById :"+flag);
        if(flag){
            var selectedItem = itemDao.getReferenceById(itemId);
            System.out.println(selectedItem);
            return itemMapping.toItemDto(selectedItem);
        }else {
            return new SelectedItemErrorStatus(2,"Selected Item not found");
        }

    }

    @Override
    public void deleteItem(String itemId) {

        Optional<ItemEntity> foundItem = itemDao.findById(itemId);
        if (!foundItem.isPresent()) {
            throw new CustomerNotFoundException("Item not found");
        }else {
            itemDao.deleteById(itemId);
        }

    }

    @Override
    public void updateItem(String itemId, ItemDto itemDto) {

        Optional<ItemEntity> findItem = itemDao.findById(itemId);
        if (!findItem.isPresent()) {
            throw new CustomerNotFoundException("Item not found");
        }else {
            /*findCustomer.get().setId(customerDto.getId());*/
            findItem.get().setName(itemDto.getName());
            findItem.get().setPrice(itemDto.getPrice());
            findItem.get().setQty(String.valueOf(itemDto.getQty()));
        }

    }
}
