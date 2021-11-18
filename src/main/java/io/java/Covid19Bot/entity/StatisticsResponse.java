package io.java.Covid19Bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // any unknown property in json with no corresponding field will be ignored
public class StatisticsResponse {

    private Integer result;  // number of countries

     private List<Country> countries;  // list country


}
