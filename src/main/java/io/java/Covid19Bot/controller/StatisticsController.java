package io.java.Covid19Bot.controller;

import io.java.Covid19Bot.entity.StatisticsResponse;
import io.java.Covid19Bot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/get-all-statistics")
    public StatisticsResponse getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    @GetMapping("/get-statistics")
    public StatisticsResponse getStatisticsByCountryName(@RequestParam(name = "country", defaultValue = "", required = false) String countryName) {
        return statisticsService.getStatisticByCountryName(countryName);
    }
}
