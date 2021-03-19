package lk.ijse.posBackEnd.service;

import lk.ijse.posBackEnd.dto.OrderDTO;
import lk.ijse.posBackEnd.dto.OrderDetailsDTO;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    void addOrder(OrderDTO dto);

    void updateOrder(OrderDTO dto);

    OrderDTO searchOrder(String id);

    void deleteOrder(String id);

    List<OrderDTO> getAllOrders();
}
