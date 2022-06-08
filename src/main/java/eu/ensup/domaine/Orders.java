package eu.ensup.domaine;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private int productid;
    private int quantity;

    public Orders(int productid, int quantity) {
        this.productid = productid;
        this.quantity = quantity;
    }

    public Orders(){}
}
