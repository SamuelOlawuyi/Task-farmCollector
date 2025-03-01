package com.assessment.farm_collector.service.impl;

import com.assessment.farm_collector.dto.HarvestedRequestDto;
import com.assessment.farm_collector.exception.ResourceNotFoundException;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.model.Harvested;
import com.assessment.farm_collector.repository.FarmRepository;
import com.assessment.farm_collector.repository.HarvestedRepository;
import com.assessment.farm_collector.service.HarvestedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HarvestedServiceImpl implements HarvestedService {

    private final HarvestedRepository harvestedRepository;
    private final FarmRepository farmRepository;
    @Override
    public Harvested submitHarvested(HarvestedRequestDto requestDto) {
        Farm farm = farmRepository.findById(requestDto.getFarmId())
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        Harvested harvested = new Harvested();
        harvested.setFarm(farm);
        harvested.setCropType(requestDto.getCropType());
        harvested.setActualAmount(requestDto.getActualAmount());
        harvested.setSeason(requestDto.getSeason());

        return harvestedRepository.save(harvested);
    }
}
