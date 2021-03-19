package lk.ijse.posBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @Id
    private String cusID;
    private String cusName;
    private String cusAddress;
    private String cusTelephone;
}
