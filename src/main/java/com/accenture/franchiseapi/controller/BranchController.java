package com.accenture.franchiseapi.controller;

import com.accenture.franchiseapi.entity.Branch;
import com.accenture.franchiseapi.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franchises")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("/{franchiseId}/branches")
    @ResponseStatus(HttpStatus.CREATED)
    public Branch create(@PathVariable Long franchiseId,
                         @RequestBody Branch branch) {
        return branchService.create(franchiseId, branch);
    }
}