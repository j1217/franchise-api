package com.accenture.franchiseapi.controller;

import com.accenture.franchiseapi.entity.Product;
import com.accenture.franchiseapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{branchId}/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@PathVariable Long branchId,
                          @RequestBody Product product) {
        return productService.create(branchId, product);
    }

    @DeleteMapping("/{branchId}/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long branchId,
                       @PathVariable Long productId) {
        productService.delete(branchId, productId);
    }

    @PutMapping("/{productId}/stock")
    public Product updateStock(@PathVariable Long productId,
                               @RequestParam Integer stock) {
        return productService.updateStock(productId, stock);
    }

    @PutMapping("/{id}/name")
    public Product updateName(@PathVariable Long id,
                              @RequestParam String name) {
        return productService.updateName(id, name);
    }
}