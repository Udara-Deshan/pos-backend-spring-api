package lk.ijse.posBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.sql.Date;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @Id
    private String orderID;
    private String cusID;
    private Date orderDate;
    private ArrayList<OrderDetailsDTO> orderDetailsDTOS;
}
