package io.java.Covid19Bot.service;

import io.java.Covid19Bot.entity.CountriesResponse;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {
    CountriesResponse getAllCountry();
}