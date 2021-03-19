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
public class Customer {
    @Id
    private String cusID;
    private String cusName;
    private String cusAddress;
    private String cusTelephone;
    @OneToMany(mappedBy = "customer",cascade= CascadeType.ALL)
    private List<Orders> orders=new ArrayList();

}
