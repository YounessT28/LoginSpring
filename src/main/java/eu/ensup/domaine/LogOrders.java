package eu.ensup.domaine;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LogOrders {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    private int order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}
