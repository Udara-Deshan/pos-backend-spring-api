package lk.ijse.posBackEnd.service.impl;

import lk.ijse.posBackEnd.dto.OrderDetailsDTO;
import lk.ijse.posBackEnd.entity.OrderDetails;
import lk.ijse.posBackEnd.repo.OrderDetailsRepo;
import lk.ijse.posBackEnd.service.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    OrderDetailsRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public String addOrderDetails(OrderDetailsDTO dto) {
        if (!repo.existsById(dto.getOrderDetailsID())) {
            OrderDetails orderDetails = mapper.map(dto, OrderDetails.class);
            repo.save(orderDetails);
            return "Order Detail already add Successfully..!";
        } else {
            return "Order Detail already exist..!";
        }
    }

    @Override
    public String updateOrderDetails(OrderDetailsDTO dto) {
        if (repo.existsById(dto.getOrderDetailsID())) {
            OrderDetails orderDetails = mapper.map(dto, OrderDetails.class);
            repo.save(orderDetails);
            return "Order Detail update Successfully..!";
        } else {
            return "Order Detail update Failed..!";
        }
    }

    @Override
    public OrderDetailsDTO searchOrderDetails(String id) {
        Optional<OrderDetails> orderDetails = repo.findById(id);
        if (orderDetails.isPresent()) {
            return mapper.map(orderDetails.get(), OrderDetailsDTO.class);
        } else {
            throw new RuntimeException("No Order Detail for id: " + id);
        }
    }

    @Override
    public String deleteOrderDetails(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Order Detail Deleted for ID: " + id;
        } else {
            return "No Order Detail for delete ID: " + id;
        }
    }

    @Override
    public List<OrderDetailsDTO> getAllOrderDetails() {
        List<OrderDetails> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDetailsDTO>>() {
        }.getType());
    }
}
