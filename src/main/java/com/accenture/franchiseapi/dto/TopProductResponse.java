package com.accenture.franchiseapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopProductResponse {

    private String branch;
    private String product;
    private Integer stock;
}