package eu.ensup.domaine;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


}
