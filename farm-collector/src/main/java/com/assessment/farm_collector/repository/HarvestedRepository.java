package com.assessment.farm_collector.repository;

import com.assessment.farm_collector.model.Harvested;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestedRepository extends JpaRepository<Harvested, Long> {
    List<Harvested> findBySeason(String season);
}
