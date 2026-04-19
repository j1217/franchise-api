package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Product;
import com.accenture.franchiseapi.repository.BranchRepository;
import com.accenture.franchiseapi.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private BranchRepository branchRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldUpdateStock() {

        Product product = Product.builder()
                .id(1L)
                .name("Big Mac")
                .stock(50)
                .build();

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        when(productRepository.save(product))
                .thenReturn(product);

        Product result = productService.updateStock(1L, 100);

        assertEquals(100, result.getStock());
    }
}