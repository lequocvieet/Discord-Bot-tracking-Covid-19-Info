package io.java.Covid19Bot.entity;

import lombok.Data;

@Data
public class Tests {
    private Integer total;

    @Override
    public String toString() {
        return "Tests: {" + " \n" +
                "        Total = " + total + " " +
                '}';
    }
}
