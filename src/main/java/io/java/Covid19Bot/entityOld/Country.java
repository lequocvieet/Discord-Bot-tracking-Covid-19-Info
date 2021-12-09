package io.java.Covid19Bot.entityOld;

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
    private String countryName;
    private Population population;
    private Date day;
    private LocalDateTime time;

}
