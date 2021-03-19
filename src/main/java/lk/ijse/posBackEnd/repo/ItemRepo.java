package lk.ijse.posBackEnd.repo;

import lk.ijse.posBackEnd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {

}
