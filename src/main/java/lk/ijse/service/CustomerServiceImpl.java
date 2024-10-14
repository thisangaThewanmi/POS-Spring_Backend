package lk.ijse.service;

import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import lk.ijse.customStatusCodes.SelectedCustomerErrorStatus;
import lk.ijse.dao.CustomerDao;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.CustomerStatus;
import lk.ijse.entity.impl.CustomerEntity;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
   Mapping customerMapping;


    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerDto.setId(AppUtil.generateCustomerId());

        CustomerEntity savedCustomer = customerDao.save(customerMapping.toCustomerEntity(customerDto));

        if (savedCustomer == null) {
            throw new DataPersistException("User not saved");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {

        return  customerMapping.asUserDTOList(customerDao.findAll());
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {

        System.out.println("customerId: " + customerId);

        boolean flag= customerDao.existsById(customerId);
        System.out.println("customerExsistsById :"+flag);
        if(flag){
            var selectedCustomer = customerDao.getReferenceById(customerId);
            System.out.println(selectedCustomer);
            return customerMapping.toCustomerDto(selectedCustomer);
        }else {
            return new SelectedCustomerErrorStatus(2,"Selected customer not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {

        Optional<CustomerEntity> foundCustomer = customerDao.findById(customerId);
        if (!foundCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(customerId);
        }

    }

    @Override
    public void updateCustomer(String customerId, CustomerDto customerDto) {

        Optional<CustomerEntity> findCustomer = customerDao.findById(customerId);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            /*findCustomer.get().setId(customerDto.getId());*/
            findCustomer.get().setName(customerDto.getName());
            findCustomer.get().setAddress(customerDto.getAddress());
            findCustomer.get().setPhone(customerDto.getPhone());
        }
    }
}
