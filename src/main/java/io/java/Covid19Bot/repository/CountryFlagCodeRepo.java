package io.java.Covid19Bot.repository;


import io.java.Covid19Bot.entity.CountryFlagCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryFlagCodeRepo extends JpaRepository<CountryFlagCode,Integer> {
    @Query(value="from CountryFlagCode x where x.countryName=?1")
    String findCodeFlagByName(String countryName );
}
