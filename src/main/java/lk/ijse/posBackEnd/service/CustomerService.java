package lk.ijse.posBackEnd.service;

import lk.ijse.posBackEnd.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO dto);

    String updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String id);

    String deleteCustomer(String id);

    List<CustomerDTO> getAllCustomers();
}

