package com.assessment.farm_collector.service.impl;

import com.assessment.farm_collector.dto.FarmRequestDto;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.repository.FarmRepository;
import com.assessment.farm_collector.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepository;

    @Override
    public Farm createFarm(FarmRequestDto requestDto) {
        Farm farm = new Farm();
        farm.setName(requestDto.getName());
        farm.setLocation(requestDto.getLocation());
        return farmRepository.save(farm);
    }
}
