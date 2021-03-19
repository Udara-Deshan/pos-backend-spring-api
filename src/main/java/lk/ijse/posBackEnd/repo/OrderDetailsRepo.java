package lk.ijse.posBackEnd.repo;

import lk.ijse.posBackEnd.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String> {
}
