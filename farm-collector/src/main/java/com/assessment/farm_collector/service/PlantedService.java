package com.assessment.farm_collector.service;

import com.assessment.farm_collector.dto.PlantedRequestDto;
import com.assessment.farm_collector.model.Planted;

public interface PlantedService {
    Planted submitPlanted(PlantedRequestDto requestDto);
}
