//By using the ExtendedIngredient class, you can represent and store information about ingredients used in a recipe, including their properties, quantities, units, and additional metadata.
package com.midterm.fooddiary.Models;

import java.util.ArrayList;

public class ExtendedIngredient {
    public int id;
    public String aisle;
    public String image;
    public String consistency;
    public String name;
    public String nameClean;
    public String original;
    public String originalName;
    public double amount;
    public String unit;
    public ArrayList<String> meta;
    public Measures measures;
}
