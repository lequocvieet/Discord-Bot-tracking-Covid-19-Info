package io.java.Covid19Bot.controller;

import io.java.Covid19Bot.entity.CountriesResponse;
import io.java.Covid19Bot.entity.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@PropertySource("classpath:APIKey.properties")
public class CountryController {

    @Value("${x-rapidapi-key}")
    private String apiKey;

    @GetMapping("/demo")
    @PostConstruct
    public CountriesResponse getAllCountry() {

        String url = "https://covid-193.p.rapidapi.com/countries";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity=new HttpEntity<String>("parameters",getHeader());
        ResponseEntity<CountriesResponse> response=restTemplate.exchange(url, HttpMethod.GET,
                entity,CountriesResponse.class);
        System.out.println(response.getBody().toString());
        return response.getBody();
    }
    private HttpHeaders getHeader(){
        HttpHeaders header=new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("x-rapidapi-key",apiKey);
        return header;
    }

}
