package org.example.petProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("value")
    private int value;

    @JsonProperty("description")
    private String description;
}
