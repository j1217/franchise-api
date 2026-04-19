package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Branch;
import com.accenture.franchiseapi.entity.Franchise;
import com.accenture.franchiseapi.entity.Product;
import com.accenture.franchiseapi.repository.FranchiseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FranchiseServiceReportTest {

    @Mock
    private FranchiseRepository franchiseRepository;

    @InjectMocks
    private FranchiseService franchiseService;

    @Test
    void shouldReturnTopProductPerBranch() {

        Product p1 = Product.builder()
                .name("Big Mac")
                .stock(50)
                .build();

        Product p2 = Product.builder()
                .name("Nuggets")
                .stock(99)
                .build();

        Branch branch = Branch.builder()
                .name("Envigado")
                .products(List.of(p1, p2))
                .build();

        Franchise franchise = Franchise.builder()
                .id(1L)
                .name("McDonalds")
                .branches(List.of(branch))
                .build();

        when(franchiseRepository.findById(1L))
                .thenReturn(Optional.of(franchise));

        var result = franchiseService.getTopProducts(1L);

        assertEquals(1, result.size());
        assertEquals("Nuggets", result.get(0).getProduct());
        assertEquals(99, result.get(0).getStock());
    }
}