package io.java.Covid19Bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // any unknown property in json with no corresponding field will be ignored
public class Country {
    private String continent;  // chau luc
    private String countryName;
    private Population population;
    private Date day;
    private LocalDateTime time;

}
