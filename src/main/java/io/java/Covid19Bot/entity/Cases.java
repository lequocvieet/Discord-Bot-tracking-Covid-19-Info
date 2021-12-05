package io.java.Covid19Bot.entity;

import lombok.Data;

@Data
public class Cases {
    private Integer  newCases;
    private Integer active;
    private Integer critical;
    private Integer recovered;
    private Integer total;

    @Override
    public String toString() {
        return "Cases: {" + " \n" +
                "        New Cases = " + newCases + " \n" +
                "        Active = " + active + " \n" +
                "        Critical = " + critical + " \n" +
                "        Recovered = " + recovered + " \n" +
                "        Total = " + total + " " +
                '}';
    }
}
