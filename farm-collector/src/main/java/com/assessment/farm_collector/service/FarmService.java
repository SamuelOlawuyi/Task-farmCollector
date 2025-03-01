package com.assessment.farm_collector.service;

import com.assessment.farm_collector.dto.FarmRequestDto;
import com.assessment.farm_collector.model.Farm;

public interface FarmService {
    Farm createFarm(FarmRequestDto farmRequestDto);
}
