package io.java.Covid19Bot.controller;

import io.java.Covid19Bot.entity.CountriesResponse;
import io.java.Covid19Bot.entity.Country;
import io.java.Covid19Bot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@PropertySource("classpath:APIKey.properties")
@RequestMapping("api/v1/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @Value("${x-rapidapi-key}")
    private String apiKey;

    @GetMapping("/demo")
    public CountriesResponse getAllCountry() {

        String url = "https://covid-193.p.rapidapi.com/countries";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity= new HttpEntity<>(getHeader());
        ResponseEntity<CountriesResponse> response=restTemplate.exchange(url, HttpMethod.GET,
                entity,CountriesResponse.class);
        //countryService.getAllCountry(response);

        //System.out.println(response.getBody().toString());
        return response.getBody();
    }
    private HttpHeaders getHeader(){
        HttpHeaders header=new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("x-rapidapi-key",apiKey);
        return header;
    }

}
