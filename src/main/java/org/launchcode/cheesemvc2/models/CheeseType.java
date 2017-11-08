package org.launchcode.cheesemvc2.models;




/**
 * Created by schwifty on 10/30/17.
 */
public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    CheeseType (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
