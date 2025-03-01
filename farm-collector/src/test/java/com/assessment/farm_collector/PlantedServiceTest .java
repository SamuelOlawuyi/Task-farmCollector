package com.assessment.farm_collector;

import com.assessment.farm_collector.dto.PlantedRequestDto;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.model.Planted;
import com.assessment.farm_collector.repository.FarmRepository;
import com.assessment.farm_collector.repository.PlantedRepository;
import com.assessment.farm_collector.service.impl.PlantedServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

    class PlantedServiceTest {

        @InjectMocks
        private PlantedServiceImpl plantedService;

        @Mock
        private PlantedRepository plantedRepository;
        @Mock
        private FarmRepository farmRepository;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void submitPlanted_ShouldReturnPlanted() {
            Farm farm = new Farm();
            when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
            PlantedRequestDto request = new PlantedRequestDto(1L, "Corn", 20.0, 200.0, "Summer 2024");
            Planted planted = new Planted(1L, "Corn", 20.0, 200.0, "Summer 2024", farm);

            when(plantedRepository.save(any(Planted.class))).thenReturn(planted);

            Planted result = plantedService.submitPlanted(request);

            assertNotNull(result);
            assertEquals("Corn", result.getCropType());
            verify(plantedRepository, times(1)).save(any(Planted.class));
        }
    }

