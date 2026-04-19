package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Franchise;
import com.accenture.franchiseapi.repository.FranchiseRepository;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public Franchise create(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }
}