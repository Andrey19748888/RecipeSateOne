package com.example.recipesite1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
public class Ingredient {


    private String name;
    private int numberOfIngredients;
    private String unit;


//    public Ingredient() {       // todo remove?
//
//    }

    @Override
    public String toString() {
        return
                "\nнаименование - " + name +
                "\n<br>количество ингредиентов - " + numberOfIngredients +
                "\n<br>единица измерения - " + unit;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//        Ingredient otherIngredient = (Ingredient)o;
//        return name.equals(otherIngredient.getName());
//    }
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }


    //    ingredient1   todo у,рать
//    ingredient2
//
//        ingredient1.equals(mapIngredient)
//        mapIngredient.equals(ingredient1);


}
