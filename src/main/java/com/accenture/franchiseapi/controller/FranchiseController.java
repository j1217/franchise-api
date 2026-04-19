package com.accenture.franchiseapi.controller;

import com.accenture.franchiseapi.dto.TopProductResponse;
import com.accenture.franchiseapi.entity.Franchise;
import com.accenture.franchiseapi.service.FranchiseService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Franchise create(@RequestBody Franchise franchise) {
        return franchiseService.create(franchise);
    }

    @GetMapping("/{franchiseId}/top-stock-products")
    public List<TopProductResponse> getTopProducts(
            @PathVariable Long franchiseId) {

        return franchiseService.getTopProducts(franchiseId);
    }

    @PutMapping("/{id}/name")
    public Franchise updateName(@PathVariable Long id,
                                @RequestParam String name) {
        return franchiseService.updateName(id, name);
    }
}