package lk.ijse.controller;

import lk.ijse.dto.ItemCartDto;
import lk.ijse.dto.ItemDto;
import lk.ijse.dto.ItemStatus;
import lk.ijse.exception.CustomerNotFoundException;
import lk.ijse.exception.DataPersistException;
import lk.ijse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@CrossOrigin(origins = "http://localhost:63342")
*/
@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    //ResponseEntity<Void>: This indicates that the method will return an HTTP response entity with a status code and no body (Void).
    public ResponseEntity<Void> addItem(@RequestBody ItemDto itemdto) {

        if (itemdto.getCode() == null || itemdto.getCode().isEmpty()) {
            throw new IllegalArgumentException("Item code cannot be null or empty");
        }
        try{

            itemService.saveItem(itemdto);
            return new  ResponseEntity<>(HttpStatus.CREATED);

        }catch(DataPersistException ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable ("id") String itemId){
        /*if (!RegexProcess.cusMatcher(customerId)) {
            System.out.println("Invalid customerId: " + customerId);  // Debugging output

            return new SelectedUserAndNoteErrorStatus(1,"Customer ID is not valid..............");
        }*/
        return itemService.getItems(itemId);
    }

    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemId") String itemId){
        try {
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDto> getALlItems(){

        return itemService.getAllItems();
    }


    @PutMapping(value = "/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable ("itemId") String itemId, @RequestBody ItemDto updatedItemDTO) {
        //validations
        try {
            itemService.updateItem(itemId, updatedItemDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

