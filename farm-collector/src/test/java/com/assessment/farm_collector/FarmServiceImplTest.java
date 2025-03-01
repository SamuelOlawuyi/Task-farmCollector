package com.assessment.farm_collector;

import com.assessment.farm_collector.dto.FarmRequestDto;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.repository.FarmRepository;
import com.assessment.farm_collector.service.impl.FarmServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FarmServiceImplTest {
    @Mock
    private FarmRepository farmRepository;

    @InjectMocks
    private FarmServiceImpl farmService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateFarm() {
        FarmRequestDto requestDto = new FarmRequestDto("Platinum Farm", "Kaduna");
        Farm farm = new Farm(1L, "Platinum Farm", "Kaduna");

        when(farmRepository.save(any(Farm.class))).thenReturn(farm);
        Farm savedFarm = farmService.createFarm(requestDto);
        assertThat(savedFarm.getName()).isEqualTo("Platinum Farm");
        assertThat(savedFarm.getLocation()).isEqualTo("Kaduna");

        verify(farmRepository, times(1)).save(any(Farm.class));
    }
}
