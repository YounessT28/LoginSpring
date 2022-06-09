package eu.ensup.service;

import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    // Save product
    public void update(Product product, int newquantity){

        Product p = this.productRepository.findByName(product.getName());
        p.setQuantity(newquantity);
        this.productRepository.save(p);
    }

    public void delete(Product product){
        this.productRepository.delete(product);
    }
}
