package com.assessment.farm_collector.repository;

import com.assessment.farm_collector.model.Planted;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantedRepository extends JpaRepository<Planted, Long> {
    List<Planted> findBySeason(String season);
}
