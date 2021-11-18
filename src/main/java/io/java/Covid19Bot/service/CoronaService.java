package io.java.Covid19Bot.service;


import io.java.Covid19Bot.entity.CountriesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@PropertySource("classpath:APIKey.properties")  // register a properties for inject later
public class CoronaService {

    @Value("${x-rapidapi-key}") // indicate the default value for apiKey
    private String apiKey;      // inject the configuration value to argument

    private CountriesResponse availableCountry;

/*PostConstruct   //this method must be executed after CoronaService bean initialize
public CountriesResponse getAllCountries(){
    if(availableCountry==null){
        RestTemplate restTemplate=new RestTemplate();
        String url ="https://covid-193.p.rapidapi.com/countries";
        HttpEntity<String> entity=new HttpEntity<String>("parameter",getHeader());
        ResponseEntity<CountriesResponse> response=restTemplate.exchange(url, HttpMethod.GET,entity, CountriesResponse.class);
        //use response entity to stored value object from remote api
        availableCountry=response.getBody();
        return  availableCountry;
    }else return availableCountry;
}*/

/*public void getStatisticsForCountry( String countryName){
    Optional<String> validatedCountry=getAllCountries().getResponse().stream().filter(x->x.equals(countryName)).findFirst();
    if(validatedCountry.isPresent()){

    }
}*/
private HttpHeaders getHeader(){
    HttpHeaders header=new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_JSON);
    header.add("x-rapidapi-key",apiKey);
    return header;
}

}
