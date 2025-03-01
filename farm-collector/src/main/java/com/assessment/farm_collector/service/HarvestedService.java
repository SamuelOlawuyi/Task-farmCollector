package com.assessment.farm_collector.service;

import com.assessment.farm_collector.dto.HarvestedRequestDto;
import com.assessment.farm_collector.model.Harvested;

public interface HarvestedService {
    Harvested submitHarvested(HarvestedRequestDto requestDto);
}
