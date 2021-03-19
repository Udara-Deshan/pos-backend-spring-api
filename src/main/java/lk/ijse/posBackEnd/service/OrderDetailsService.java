package lk.ijse.posBackEnd.service;

import lk.ijse.posBackEnd.dto.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsService {
    String addOrderDetails(OrderDetailsDTO dto);

    String updateOrderDetails(OrderDetailsDTO dto);

    OrderDetailsDTO searchOrderDetails(String id);

    String deleteOrderDetails(String id);

    List<OrderDetailsDTO> getAllOrderDetails();
}
