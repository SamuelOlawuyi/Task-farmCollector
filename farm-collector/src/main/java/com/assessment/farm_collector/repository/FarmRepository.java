package com.assessment.farm_collector.repository;

import com.assessment.farm_collector.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
