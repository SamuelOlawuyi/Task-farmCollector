package com.assessment.farm_collector;

import com.assessment.farm_collector.dto.HarvestedRequestDto;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.model.Harvested;
import com.assessment.farm_collector.repository.FarmRepository;
import com.assessment.farm_collector.repository.HarvestedRepository;
import com.assessment.farm_collector.service.impl.HarvestedServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class HarvestedServiceTest {

    @InjectMocks
    private HarvestedServiceImpl harvestedService;

    @Mock
    private HarvestedRepository harvestedRepository;

    @Mock
    private FarmRepository farmRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void submitHarvested_ShouldReturnHarvested() {

        Farm farm = new Farm();
        farm.setId(1L);

        HarvestedRequestDto request = new HarvestedRequestDto(1L, "Corn", 180.0, "Summer 2024");

        Harvested harvested = new Harvested(1L, farm, "Corn", 180.0, "Summer 2024");

       when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));

       when(harvestedRepository.save(any(Harvested.class))).thenReturn(harvested);

       Harvested result = harvestedService.submitHarvested(request);

        assertNotNull(result);
        assertEquals(180.0, result.getActualAmount());
        verify(farmRepository, times(1)).findById(1L); // Ensure farmRepository is called
        verify(harvestedRepository, times(1)).save(any(Harvested.class));
    }
}
