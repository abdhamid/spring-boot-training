package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity add(ProductDto request) {
        ProductEntity product = new ProductEntity();
        product.setProductName(request.getProductName());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());

        return productRepository.save(product);
    }

    public List<ProductEntity> fetch(Long price){
        if (price == 0){
            //fetch all product with stock > 0
            return fetchAll();
        } else {
            return fetchAllUnderPrice(price);
        }
    }

    public List<ProductEntity> fetchAll(){
//        List<ProductEntity> res = new ArrayList<>();
//        Iterable<ProductEntity> prod = productRepository.findAll();
//        res = StreamSupport.stream(prod.spliterator(), false)
//                .collect(Collectors.toList());
        return (List<ProductEntity>) productRepository.findAll();
    }

    public List<ProductEntity> fetchAllInStock(){
        //return all in stock
        return productRepository.findByStockGreaterThan(10);
    }

    public List<ProductEntity> fetchAllUnderPrice(Long price){
        //return all in stock
        return productRepository.findByPriceLessThanEqual(price);
    }



    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ProductEntity getById(Long id) {
        return productRepository.findById(id).orElse(new ProductEntity());
    }

    public ProductEntity updateStock(UpdateStockDto request){
        //get product by id in db
        ProductEntity product = getById(request.getId());
        //update product stock
        long currentStock = product.getStock();
        long updatedStock = currentStock + request.getStock();
        product.setStock(updatedStock);
        //save updated product to db
        return productRepository.save(product);
    }
}
