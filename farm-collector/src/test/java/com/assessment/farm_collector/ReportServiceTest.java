package com.assessment.farm_collector;

import com.assessment.farm_collector.dto.ApiResponse;
import com.assessment.farm_collector.repository.PlantedRepository;
import com.assessment.farm_collector.service.impl.ReportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {

    @InjectMocks
    private ReportServiceImpl reportService;

    @Mock
    private PlantedRepository plantedRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateReport_ShouldReturnNoData() {
        when(plantedRepository.findBySeason("Winter 2024")).thenReturn(Collections.emptyList());

        ApiResponse<String> response = reportService.generateReport("Winter 2024");

        assertNotNull(response);
        assertEquals("No data found for season: Winter 2024", response.getMessage());
    }
}
