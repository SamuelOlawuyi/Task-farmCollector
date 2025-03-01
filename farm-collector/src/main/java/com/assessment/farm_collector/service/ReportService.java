package com.assessment.farm_collector.service;

import com.assessment.farm_collector.dto.ApiResponse;

public interface ReportService {
    ApiResponse<String> generateReport(String season);
}
