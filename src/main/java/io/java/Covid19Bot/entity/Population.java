package io.java.Covid19Bot.entity;

import lombok.Data;

@Data
public class Population {
  private Integer populationNumber;
  private Cases cases;
  private Deaths deaths;
  private Tests tests;
}
