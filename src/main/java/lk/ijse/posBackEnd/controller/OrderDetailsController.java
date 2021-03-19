package lk.ijse.posBackEnd.controller;

import lk.ijse.posBackEnd.dto.CustomerDTO;
import lk.ijse.posBackEnd.dto.OrderDetailsDTO;
import lk.ijse.posBackEnd.entity.OrderDetails;
import lk.ijse.posBackEnd.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order_details")
@CrossOrigin
public class OrderDetailsController {
    @Autowired
    OrderDetailsService orderDetailsService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addOrderDetail(@RequestBody OrderDetailsDTO dto) {
        return new ResponseEntity(orderDetailsService.addOrderDetails(dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"orderDetailsID"})
    public ResponseEntity deleteOrderDetail(@RequestParam String orderDetailsID) {
        return  new ResponseEntity(orderDetailsService.deleteOrderDetails(orderDetailsID), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateOrderDetail(@RequestBody OrderDetailsDTO dto) {
        return  new ResponseEntity(orderDetailsService.updateOrderDetails(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/{orderDetailsID}")
    public ResponseEntity searchOrderDetails(@PathVariable String orderDetailsID) {
        OrderDetailsDTO customerDTO;
        return  new ResponseEntity(customerDTO = orderDetailsService.searchOrderDetails(orderDetailsID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllOrderDetails() {
        List<OrderDetailsDTO> allCustomers;
        return  new ResponseEntity(allCustomers = orderDetailsService.getAllOrderDetails(), HttpStatus.OK);
    }
}
