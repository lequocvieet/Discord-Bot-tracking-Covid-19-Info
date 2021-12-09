package io.java.Covid19Bot.entityOld;

import lombok.Data;

@Data
public class Cases {
    private Integer  newCases;
    private Integer active;
    private Integer critical;
    private Integer recovered;
    private Integer total;
}
