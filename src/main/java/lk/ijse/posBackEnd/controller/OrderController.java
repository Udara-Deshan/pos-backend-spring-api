package lk.ijse.posBackEnd.controller;

import lk.ijse.posBackEnd.dto.CustomerDTO;
import lk.ijse.posBackEnd.dto.OrderDTO;
import lk.ijse.posBackEnd.service.CustomerService;
import lk.ijse.posBackEnd.service.OrderService;
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
    OrderService orderService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody OrderDTO dto) {
        System.out.println("come");
        System.out.println(dto.getCusID()+" "+dto.getOrderID());
        return new ResponseEntity(orderService.addOrder(dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        orderService.deleteOrder(id);
        return null;
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody OrderDTO dto) {
        orderService.updateOrder(dto);
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        OrderDTO orderDTO = orderService.searchOrder(id);
        return null;
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<OrderDTO> allOrders= orderService.getAllOrders();
        return null;
    }

}
