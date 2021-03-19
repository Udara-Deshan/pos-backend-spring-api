package lk.ijse.posBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {
    @Id
    private String orderDetailsID;
    private String orderID;
    private String itemID;
    private int qty;
}
