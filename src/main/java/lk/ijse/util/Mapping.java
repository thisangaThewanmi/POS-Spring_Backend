package lk.ijse.util;

import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.impl.CustomerEntity;
import lk.ijse.entity.impl.ItemEntity;
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
    /*//for note mapping
    public NoteDTO toNoteDTO(NoteEntity noteEntity) {
        return modelMapper.map(noteEntity, NoteDTO.class);
    }
    public NoteEntity toNoteEntity(NoteDTO noteDTO) {
        return modelMapper.map(noteDTO, NoteEntity.class);
    }
    public List<NoteDTO> asNoteDTOList(List<NoteEntity> noteEntities) {
        return modelMapper.map(noteEntities, new TypeToken<List<NoteDTO>>() {}.getType());
    }*/

}
