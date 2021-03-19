package lk.ijse.posBackEnd.repo;

import lk.ijse.posBackEnd.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {


}
