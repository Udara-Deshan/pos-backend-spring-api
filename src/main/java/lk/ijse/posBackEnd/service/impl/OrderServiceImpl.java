package lk.ijse.posBackEnd.service.impl;

import lk.ijse.posBackEnd.dto.OrderDTO;
import lk.ijse.posBackEnd.dto.OrderDetailsDTO;
import lk.ijse.posBackEnd.entity.Orders;
import lk.ijse.posBackEnd.repo.OrderRepo;
import lk.ijse.posBackEnd.service.OrderDetailsService;
import lk.ijse.posBackEnd.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    OrderDetailsService orderDetailsService;

    @Override
    @Transactional
    public String addOrder(OrderDTO dto) {
        if (!repo.existsById(dto.getOrderID())) {
            Orders orders = mapper.map(dto, Orders.class);
            repo.save(orders);
            for (OrderDetailsDTO orderDetailsDTO : dto.getOrderDetailsDTOS()) {
                orderDetailsService.addOrderDetails(orderDetailsDTO);
            }
            return "Order add Successfully..!";
        } else {
            return "Order already exist..!";
        }
    }

    @Override
    public void updateOrder(OrderDTO dto) {
        if (repo.existsById(dto.getOrderID())) {
            Orders orders = mapper.map(dto, Orders.class);
            repo.save(orders);
        } else {
            throw new RuntimeException("No such order for update..!");
        }
    }

    @Override
    public OrderDTO searchOrder(String id) {
        Optional<Orders> order = repo.findById(id);
        if (order.isPresent()) {
            return mapper.map(order.get(), OrderDTO.class);
        } else {
            throw new RuntimeException("No order for id: " + id);
        }    }

    @Override
    public void deleteOrder(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No order for delete ID: " + id);
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Orders> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDTO>>() {
        }.getType());
    }
}
