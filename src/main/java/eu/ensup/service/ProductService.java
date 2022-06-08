package eu.ensup.service;

import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Product;
import eu.ensup.domaine.User;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Inscription
    public void create(Product product){
        this.productRepository.save(product); // Methode proposé par CrudRepository pour enregistrer une entité dans la base de données
    }

    // Connexion
    public Product findUser(Product product){
        return this.productRepository.findByName(product.getName());
    }
}
