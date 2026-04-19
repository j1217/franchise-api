package com.accenture.franchiseapi.service;

import com.accenture.franchiseapi.entity.Franchise;
import com.accenture.franchiseapi.repository.FranchiseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FranchiseServiceTest {

    @Mock
    private FranchiseRepository franchiseRepository;

    @InjectMocks
    private FranchiseService franchiseService;

    @Test
    void shouldCreateFranchise() {

        Franchise franchise = Franchise.builder()
                .name("McDonalds")
                .build();

        when(franchiseRepository.save(franchise)).thenReturn(franchise);

        Franchise result = franchiseService.create(franchise);

        assertEquals("McDonalds", result.getName());
    }
}