package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Branch;
import com.accenture.franchiseapi.entity.Franchise;
import com.accenture.franchiseapi.repository.BranchRepository;
import com.accenture.franchiseapi.repository.FranchiseRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    private final FranchiseRepository franchiseRepository;

    public BranchService(BranchRepository branchRepository,
                         FranchiseRepository franchiseRepository) {
        this.branchRepository = branchRepository;
        this.franchiseRepository = franchiseRepository;
    }

    public Branch create(Long franchiseId, Branch branch) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));

        branch.setFranchise(franchise);

        return branchRepository.save(branch);
    }

    public Branch updateName(Long id, String name) {

        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branch.setName(name);

        return branchRepository.save(branch);
    }
}