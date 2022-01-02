package io.java.Covid19Bot.service;


import io.java.Covid19Bot.entity.StatisticsResponse;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsService {
    StatisticsResponse getAllStatistics();
    StatisticsResponse getStatisticByCountryName(String countryName);
    String getCodeFlagByName(String countryName);
}
