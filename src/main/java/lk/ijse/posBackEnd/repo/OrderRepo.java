package lk.ijse.posBackEnd.repo;

import lk.ijse.posBackEnd.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,String> {
}
