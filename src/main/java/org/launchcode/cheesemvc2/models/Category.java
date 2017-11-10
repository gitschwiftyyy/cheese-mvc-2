package org.launchcode.cheesemvc2.models;

import org.launchcode.cheesemvc2.models.Cheese;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by schwifty on 11/9/17.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Cheese> getCheeses() {
        return cheeses;
    }
    public void setCheeses(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }
}
