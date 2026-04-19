package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Franchise;
import com.accenture.franchiseapi.repository.FranchiseRepository;
import org.springframework.stereotype.Service;
import com.accenture.franchiseapi.dto.TopProductResponse;
import com.accenture.franchiseapi.entity.Branch;
import com.accenture.franchiseapi.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public Franchise create(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public List<TopProductResponse> getTopProducts(Long franchiseId) {

        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));

        List<TopProductResponse> response = new ArrayList<>();

        for (Branch branch : franchise.getBranches()) {

            branch.getProducts().stream()
                    .max(Comparator.comparing(Product::getStock))
                    .ifPresent(product ->
                            response.add(
                                    new TopProductResponse(
                                            branch.getName(),
                                            product.getName(),
                                            product.getStock()
                                    )
                            ));
        }

        return response;
    }

    public Franchise updateName(Long id, String name) {

        Franchise franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));

        franchise.setName(name);

        return franchiseRepository.save(franchise);
    }
}