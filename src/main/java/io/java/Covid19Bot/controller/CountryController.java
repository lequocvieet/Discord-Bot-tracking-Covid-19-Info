package io.java.Covid19Bot.controller;

import io.java.Covid19Bot.entityOld.CountriesResponse;
import io.java.Covid19Bot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
