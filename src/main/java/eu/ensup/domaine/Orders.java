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
    private int product_id;
    private int quantity;

    public Orders(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Orders(){}
}
