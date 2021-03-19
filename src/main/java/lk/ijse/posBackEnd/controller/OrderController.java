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
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    O customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto) {
        customerService.saveCustomer(dto);
        return new ResponseEntity(customerService.saveCustomer(dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return null;
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        customerService.updateCustomer(dto);
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return null;
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return null;
    }

}
