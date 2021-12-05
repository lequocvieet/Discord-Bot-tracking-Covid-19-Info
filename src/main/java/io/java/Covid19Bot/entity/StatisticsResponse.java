package io.java.Covid19Bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true) // any unknown property in json with no corresponding field will be ignored
public class StatisticsResponse {

    private Integer results;  // number of countries

    private List<Country> response;  // list country

}
