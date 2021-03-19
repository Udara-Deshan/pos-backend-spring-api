package lk.ijse.posBackEnd.controller;


import lk.ijse.posBackEnd.dto.CustomerDTO;
import lk.ijse.posBackEnd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto) {
        return new ResponseEntity(customerService.saveCustomer(dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"cusID"})
    public ResponseEntity deleteCustomer(@RequestParam String cusID) {
        return  new ResponseEntity(customerService.deleteCustomer(cusID), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        return  new ResponseEntity(customerService.updateCustomer(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/{cusID}")
    public ResponseEntity searchCustomer(@PathVariable String cusID) {
        CustomerDTO customerDTO;
        return  new ResponseEntity(customerDTO = customerService.searchCustomer(cusID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerDTO> allCustomers;
        return  new ResponseEntity(allCustomers = customerService.getAllCustomers(), HttpStatus.OK);
    }

}
