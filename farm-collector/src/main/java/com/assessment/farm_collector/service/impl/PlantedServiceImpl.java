package com.assessment.farm_collector.service.impl;

import com.assessment.farm_collector.dto.PlantedRequestDto;
import com.assessment.farm_collector.exception.ResourceNotFoundException;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.model.Planted;
import com.assessment.farm_collector.repository.FarmRepository;
import com.assessment.farm_collector.repository.PlantedRepository;
import com.assessment.farm_collector.service.PlantedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantedServiceImpl implements PlantedService {
    private final PlantedRepository plantedRepository;
    private final FarmRepository farmRepository;
    @Override
    public Planted submitPlanted(PlantedRequestDto requestDto) {
        Farm farm = farmRepository.findById(requestDto.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        Planted planted = new Planted();
        planted.setFarm(farm);
        planted.setCropType(requestDto.getCropType());
        planted.setPlantingArea(requestDto.getPlantingArea());
        planted.setExpectedAmount(requestDto.getExpectedAmount());
        planted.setSeason(requestDto.getSeason());
        return plantedRepository.save(planted);
    }
}
