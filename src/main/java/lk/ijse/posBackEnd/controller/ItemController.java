package lk.ijse.posBackEnd.controller;

import lk.ijse.posBackEnd.dto.ItemDTO;
import lk.ijse.posBackEnd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody ItemDTO dto) {
        return new ResponseEntity(itemService.saveItem(dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"itemID"})
    public ResponseEntity deleteCustomer(@RequestParam String itemID) {
        return new ResponseEntity(itemService.deleteItem(itemID), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody ItemDTO dto) {
        return new ResponseEntity(itemService.updateItem(dto), HttpStatus.OK);
    }

    @GetMapping(path = "/{itemID}")
    public ResponseEntity searchCustomer(@PathVariable String itemID) {
        ItemDTO itemDTO ;
        return new ResponseEntity(itemDTO = itemService.searchItem(itemID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<ItemDTO> allItems;
        return new ResponseEntity(allItems = itemService.getAllItems(), HttpStatus.OK);
    }
}
