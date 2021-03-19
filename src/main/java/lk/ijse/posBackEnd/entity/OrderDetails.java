package lk.ijse.posBackEnd.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {
    @Id
    private String orderDetailsID;
    private int qty;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", nullable = false)
    private Orders orders;


}
