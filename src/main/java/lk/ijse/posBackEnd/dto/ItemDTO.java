package lk.ijse.posBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    @Id
    private String itemID;
    private String itemName;
    private double itemPrice;
    private int itemQty;
}
