package io.java.Covid19Bot.service.Impl;

import io.java.Covid19Bot.entity.CountryFlagCode;
import io.java.Covid19Bot.entity.StatisticsResponse;
import io.java.Covid19Bot.repository.CountryFlagCodeRepo;
import io.java.Covid19Bot.service.CountryService;
import io.java.Covid19Bot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@PropertySource("classpath:APIKey.properties")
public class StatisticsServiceImpl implements StatisticsService {

    @Value("${x-rapidapi-key}")
    private String apiKey;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryFlagCodeRepo countryFlagRepo;

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
        // capitalize first letter
        String countryName1 = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);
        Optional<String> validatedCountry = countryService.getAllCountry()       //Get Country
                .getResponse()
                .stream()
                .filter(countryBank -> countryBank.equals(countryName1))
                .findFirst();
        if (validatedCountry.isPresent()) {
            System.out.println(validatedCountry.get() + " Is Country selected");    //Print Country Selected to Console
            String url = "https://covid-193.p.rapidapi.com/statistics?country="+"{"+ countryName +"}";
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> entity = new HttpEntity<>(getHeader());
            ResponseEntity<StatisticsResponse> response = restTemplate.exchange(url, HttpMethod.GET,
                    entity, StatisticsResponse.class, validatedCountry.get());
            return response.getBody();
        }
        return null;
    }

    @Override
    public String getCodeFlagByName(String countryName) {
        ResourceBundle MESSAGE = ResourceBundle.getBundle("ErrorMessage");

        // capitalize first letter
        String output = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);
        List<String> countries= countryService.getAllCountry().getResponse();
        for(int i=0;i< countries.size();i++){
            if(output.equals(countries.get(i))){
                return countryFlagRepo.findCodeFlagByName(output);
            }
        }
        return MESSAGE.getString("ERRORMESSAGE");

        }
    private HttpHeaders getHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("x-rapidapi-key", apiKey);
        return header;
    }
}
