package lk.ijse.posBackEnd.service;

import lk.ijse.posBackEnd.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    String addOrder(OrderDTO dto);

    void updateOrder(OrderDTO dto);

    OrderDTO searchOrder(String id);

    void deleteOrder(String id);

    List<OrderDTO> getAllOrders();
}
