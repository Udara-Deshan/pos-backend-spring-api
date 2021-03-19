package lk.ijse.posBackEnd.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    private String orderID;
    private Date orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cusid", referencedColumnName = "cusid", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "orders",cascade= CascadeType.ALL)
    private List<OrderDetails> orderDetails=new ArrayList();
}
