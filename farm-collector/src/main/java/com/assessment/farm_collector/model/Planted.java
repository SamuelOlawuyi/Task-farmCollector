package com.assessment.farm_collector.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropType;
    private double plantingArea;
    private double expectedAmount;
    private String season;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

}
