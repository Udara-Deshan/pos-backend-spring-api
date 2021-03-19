package lk.ijse.posBackEnd.service.impl;

import lk.ijse.posBackEnd.dto.CustomerDTO;
import lk.ijse.posBackEnd.entity.Customer;
import lk.ijse.posBackEnd.repo.CustomerRepo;
import lk.ijse.posBackEnd.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public String saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getCusID())) {
            Customer customer = mapper.map(dto, Customer.class);
            repo.save(customer);
            return "Customer saved Successfully..!";
        } else {
            return "Customer already exist..!";
        }
    }

    @Override
    public String updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getCusID())) {
            Customer c = mapper.map(dto, Customer.class);
            repo.save(c);
            return "Customer update Successfully..!";
        } else {
            return "No such customer for update..!";
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No customer for id: " + id);
        }
    }

    @Override
    public String deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Customer deleted for ID: " + id;

        } else {
            return "No customer for delete ID: " + id;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
