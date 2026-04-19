package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Branch;
import com.accenture.franchiseapi.entity.Product;
import com.accenture.franchiseapi.repository.BranchRepository;
import com.accenture.franchiseapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public ProductService(ProductRepository productRepository,
                          BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    public Product create(Long branchId, Product product) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        product.setBranch(branch);

        return productRepository.save(product);
    }
}