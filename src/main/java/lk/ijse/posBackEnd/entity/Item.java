package lk.ijse.posBackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {
    @Id
    private String itemID;
    private String itemName;
    private double itemPrice;
    private int itemQty;
    @OneToMany(mappedBy = "item",cascade= CascadeType.ALL)
    private List<OrderDetails> orderDetails=new ArrayList();
}
