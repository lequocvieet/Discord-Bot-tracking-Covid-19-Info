package io.java.Covid19Bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // any unknown property in json with no corresponding field will be ignore
@Data
public class CountriesResponse {
   private Integer result;  // number of all countries
   private List<Country> response; // list countries

}
