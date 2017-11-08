package org.launchcode.cheesemvc2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by schwifty on 10/30/17.
 */
@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    public void setType(CheeseType type) {
        this.type = type;
    }
private CheeseType type;


public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
        }

public Cheese() {}

    public int getId() {
        return id;
    }

public String getName() {
        return name;
        }

public void setName(String name) {
        this.name = name;
        }

public String getDescription() {
        return description;
        }

public void setDescription(String description) {
        this.description = description;
        }

public CheeseType getType() {
        return type;
        }




}
