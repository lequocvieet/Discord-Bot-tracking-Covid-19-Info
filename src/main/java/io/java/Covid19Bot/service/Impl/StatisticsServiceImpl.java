package io.java.Covid19Bot.service.Impl;

import io.java.Covid19Bot.entity.StatisticsResponse;
import io.java.Covid19Bot.service.CountryService;
import io.java.Covid19Bot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@PropertySource("classpath:APIKey.properties")
public class StatisticsServiceImpl implements StatisticsService {

    @Value("${x-rapidapi-key}")
    private String apiKey;

    @Autowired
    private CountryService countryService;

    @Override
    public StatisticsResponse getAllStatistics() {
        String url = "https://covid-193.p.rapidapi.com/statistics";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(getHeader());
        ResponseEntity<StatisticsResponse> response = restTemplate.exchange(url, HttpMethod.GET,
                entity, StatisticsResponse.class);
        return response.getBody();
    }

    @Override
    public StatisticsResponse getStatisticByCountryName(String countryName) {
        Optional<String> validatedCountry = countryService.getAllCountry()       //Get Country
                .getResponse()
                .stream()
                .filter(countryBank -> countryBank.equals(countryName))
                .findFirst();
        if (validatedCountry.isPresent()) {
            System.out.println(validatedCountry.get() + " Is Country selected");    //Print Country Selected to Console
            String url = "https://covid-193.p.rapidapi.com/statistics?country={country}";
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> entity = new HttpEntity<>(getHeader());
            ResponseEntity<StatisticsResponse> response = restTemplate.exchange(url, HttpMethod.GET,
                    entity, StatisticsResponse.class, validatedCountry.get());
            return response.getBody();
        }
        return null;
    }

    private HttpHeaders getHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("x-rapidapi-key", apiKey);
        return header;
    }
}
