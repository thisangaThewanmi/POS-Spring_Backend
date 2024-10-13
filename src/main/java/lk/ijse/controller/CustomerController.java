package lk.ijse.controller;

import lk.ijse.customStatusCodes.SelectedUserAndNoteErrorStatus;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.CustomerStatus;
import lk.ijse.exception.CustomerNotFoundException;
import lk.ijse.exception.DataPersistException;
import lk.ijse.service.CustomerService;
import lk.ijse.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveNote(@RequestBody CustomerDto customerDto) {
        try {
            customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectedCustomer(@PathVariable ("id") String customerId){
        /*if (!RegexProcess.cusMatcher(customerId)) {
            System.out.println("Invalid customerId: " + customerId);  // Debugging output

            return new SelectedUserAndNoteErrorStatus(1,"Customer ID is not valid..............");
        }*/
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{cusId}")
    public ResponseEntity<Void> deleteNote(@PathVariable ("cusId") String cusId){
        try {
            if (!RegexProcess.cusMatcher(cusId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(cusId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
