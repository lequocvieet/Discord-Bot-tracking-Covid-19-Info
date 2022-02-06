package io.java.Covid19Bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // any unknown property in json with no corresponding field will be ignored
public class Country {
    private String continent;  // chau luc
    private String country;
    private Integer population;
    private Cases cases;
    private Deaths deaths;
    private Tests tests;
    private Date day;
    private String time;

}
