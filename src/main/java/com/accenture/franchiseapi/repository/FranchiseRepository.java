package com.accenture.franchiseapi.repository;

import com.accenture.franchiseapi.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}