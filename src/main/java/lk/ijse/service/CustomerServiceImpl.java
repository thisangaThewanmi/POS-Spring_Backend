package lk.ijse.service;

import jakarta.transaction.Transactional;
import lk.ijse.dao.CustomerDao;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.CustomerStatus;
import lk.ijse.entity.impl.CustomerEntity;
import lk.ijse.exception.DataPersistException;
import lk.ijse.util.AppUtil;
import lk.ijse.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
   Mapping mapping;


    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerDto.setId(AppUtil.generateCustomerId());

        CustomerEntity savedCustomer = customerDao.save(mapping.toCustomerEntity(customerDto));

        if (savedCustomer == null) {
            throw new DataPersistException("User not saved");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerStatus getCustomer(String noteId) {
        return null;
    }

    @Override
    public void deleteCustomer(String noteId) {

    }

    @Override
    public void updateCustomer(String customerId, CustomerDto customerDto) {

    }
}
