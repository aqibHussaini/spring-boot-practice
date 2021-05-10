package com.myproject.Services;

import com.myproject.Entitiy.Product;
import com.myproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class productService
{
    @Autowired
    ProductRepository productRepository;
    public Product save(Product product)
    {
       return this.productRepository.save(product);
    }
    public List<Product> getAll()
    {
       return this.productRepository.findAll();
    }

}