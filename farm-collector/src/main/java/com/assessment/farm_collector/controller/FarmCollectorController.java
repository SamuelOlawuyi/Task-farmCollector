package com.assessment.farm_collector.controller;

import com.assessment.farm_collector.dto.ApiResponse;
import com.assessment.farm_collector.dto.FarmRequestDto;
import com.assessment.farm_collector.dto.HarvestedRequestDto;
import com.assessment.farm_collector.dto.PlantedRequestDto;
import com.assessment.farm_collector.model.Farm;
import com.assessment.farm_collector.model.Harvested;
import com.assessment.farm_collector.model.Planted;
import com.assessment.farm_collector.service.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FarmCollectorController {
    private final FarmService farmService;
    private final HarvestedService harvestedService;
    private final PlantedService plantedService;
    private final ReportService reportService;

    public FarmCollectorController(FarmService farmService, HarvestedService harvestedService, PlantedService plantedService, ReportService reportService) {
        this.farmService = farmService;
        this.harvestedService = harvestedService;
        this.plantedService = plantedService;
        this.reportService = reportService;
    }

    @PostMapping("/farms")
    public ResponseEntity<ApiResponse<Farm>> createFarm(@RequestBody FarmRequestDto requestDto) {
        Farm farm = farmService.createFarm(requestDto);
        ApiResponse<Farm> response = new ApiResponse<>("Farm Created Successfully", farm);
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/planted")
    public ResponseEntity<ApiResponse<Planted>> submitPlanted(@RequestBody PlantedRequestDto requestDto) {
        Planted planted = plantedService.submitPlanted(requestDto);
        ApiResponse<Planted> response = new ApiResponse<>("Planted Data Saved", planted);
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/harvested")
    public ResponseEntity<ApiResponse<Harvested>> submitHarvested(@RequestBody HarvestedRequestDto requestDto) {
        Harvested harvested = harvestedService.submitHarvested(requestDto);
        ApiResponse<Harvested> response = new ApiResponse<>("Harvested Data Saved", harvested);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/reports/{season}")
    public ResponseEntity<String> generateReport(@PathVariable String season) {
        ApiResponse<String> reportResponse = reportService.generateReport(season);
        String report = reportResponse.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }
}