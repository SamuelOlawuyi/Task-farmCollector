package com.assessment.farm_collector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestedRequestDto {
    private Long farmId;
    private String cropType;
    private double actualAmount;
    private String season;
}
