package lk.ijse.service;

import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.CustomerStatus;

import java.util.List;


public interface CustomerService {
        void saveCustomer(CustomerDto customerDto);
        List<CustomerDto> getAllCustomers();
        CustomerStatus getCustomer(String noteId);
        void deleteCustomer(String noteId);
        void updateCustomer(String customerId, CustomerDto customerDto);
    }

