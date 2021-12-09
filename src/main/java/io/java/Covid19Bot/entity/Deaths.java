package io.java.Covid19Bot.entity;

import lombok.Data;

@Data
public class Deaths {
    private Integer newDeath;
    private Integer total;

    @Override
    public String toString() {
        return "Deaths: {" + " \n" +
                "         New Death = " + newDeath + " \n" +
                "         Total = " + total + " " +
                '}';
    }
}
