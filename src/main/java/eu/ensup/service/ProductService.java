package eu.ensup.service;

import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }

    // Save product
    public void create(Product product){
        this.productRepository.save(product);
    }

    // Get product
    public Product findUser(Product product){
        return this.productRepository.findByName(product.getName());
    }
}
