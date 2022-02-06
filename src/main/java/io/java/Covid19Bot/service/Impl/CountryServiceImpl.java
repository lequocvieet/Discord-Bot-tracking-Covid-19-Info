package io.java.Covid19Bot.service.Impl;


import io.java.Covid19Bot.entity.CountriesResponse;
import io.java.Covid19Bot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:APIKey.properties")
public class CountryServiceImpl implements CountryService {

    @Value("${x-rapidapi-key}")
    private String apiKey;

    @Override
    public CountriesResponse getAllCountry() {
        String url = "https://covid-193.p.rapidapi.com/countries";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(getHeader());
        ResponseEntity<CountriesResponse> response = restTemplate.exchange(url, HttpMethod.GET,
                entity, CountriesResponse.class);
        return response.getBody();
    }

    private HttpHeaders getHeader() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("x-rapidapi-key", apiKey);
        return header;
    }
}