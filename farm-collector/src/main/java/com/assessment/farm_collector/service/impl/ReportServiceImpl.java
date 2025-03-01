package com.assessment.farm_collector.service.impl;

import com.assessment.farm_collector.dto.ApiResponse;
import com.assessment.farm_collector.model.Harvested;
import com.assessment.farm_collector.model.Planted;
import com.assessment.farm_collector.repository.HarvestedRepository;
import com.assessment.farm_collector.repository.PlantedRepository;
import com.assessment.farm_collector.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final PlantedRepository plantedRepository;
    private final HarvestedRepository harvestedRepository;
    @Override
    public ApiResponse<String> generateReport(String season) {
        // Fetch planted and harvested data for the requested season
        List<Planted> plantedList = plantedRepository.findBySeason(season);
        List<Harvested> harvestedList = harvestedRepository.findBySeason(season);

        if (plantedList.isEmpty()) {
            return new ApiResponse<>("No data found for season: " + season, "");
        }

        StringBuilder report = new StringBuilder("Season Report for: " + season + "\n\n");

        for (Planted planted : plantedList) {
            double actualHarvested = harvestedList.stream()
                    .filter(h -> h.getCropType().equalsIgnoreCase(planted.getCropType())
                            && h.getFarm().getId().equals(planted.getFarm().getId()))
                    .mapToDouble(Harvested::getActualAmount)
                    .sum();

            report.append("Farm Name: ").append(planted.getFarm().getName()).append("\n")
                    .append("Crop Type: ").append(planted.getCropType()).append("\n")
                    .append("Expected Amount: ").append(planted.getExpectedAmount()).append(" tons\n")
                    .append("Actual Harvested: ").append(actualHarvested).append(" tons\n")
                    .append("=========================================================\n");
        }

        return new ApiResponse<>("Report Generated Successfully", report.toString());
    }
}
