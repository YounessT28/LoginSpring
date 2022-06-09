package eu.ensup.dao;

import eu.ensup.domaine.Product;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

}
