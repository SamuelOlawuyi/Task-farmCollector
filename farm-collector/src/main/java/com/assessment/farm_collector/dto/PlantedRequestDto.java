package com.assessment.farm_collector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantedRequestDto {
    private Long farmId;
    private String cropType;
    private double plantingArea;
    private double expectedAmount;
    private String season;
}
