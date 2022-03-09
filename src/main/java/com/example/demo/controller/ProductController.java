package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("")
//    public List<ProductEntity> getProducts(@RequestParam(value = "inStock", defaultValue = "0") boolean isInStock) {
//        return productService.fetch(isInStock);
//    }

    @GetMapping("")
    public List<ProductEntity> getProducts(@RequestParam(value = "underPrice", defaultValue = "0") Long price) {
        return productService.fetch(price);
    }

    @GetMapping("{id}")
    public ProductEntity getProduct(@PathVariable("id") String id) {
        return productService.getById(Long.parseLong(id));
    }

    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDto productDto) {
        return productService.add(productDto);
//        return new CommonResponse("Successfully add new product");
    }

    @PutMapping("/stock")
    public ProductEntity updateStock(@RequestBody UpdateStockDto request) {
        return productService.updateStock(request);
    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(Long.parseLong(id));
        return new CommonResponse("Successfully delete product");
    }

}
