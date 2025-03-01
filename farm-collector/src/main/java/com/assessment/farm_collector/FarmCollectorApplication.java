package com.assessment.farm_collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.assessment.farm_collector.repository")
public class FarmCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmCollectorApplication.class, args);
	}

}
