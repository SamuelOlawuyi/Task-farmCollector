package com.assessment.farm_collector.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
        private String message;
        private T data;

        public ApiResponse(String message, T data) {
                this.message = message;
                this.data = data;
        }
}
