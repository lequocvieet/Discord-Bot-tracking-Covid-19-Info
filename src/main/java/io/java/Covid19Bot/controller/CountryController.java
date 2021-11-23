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
@RequestMapping("api/v1/country")
public class CountryController {

    @Autowired
    CountryService countryService;
    @GetMapping("/get-all-country")
    public CountriesResponse getAllCountry() {
        return countryService.getAllCountry();
    }

}
