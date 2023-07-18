package com.example.recipesite1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Objects;


@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "ingredients"}) //"  ingredients")


public class Recipe {

    private String name;
    private int time;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> steps;


    public Recipe() {}

    // public Recipe(String name, int time, ArrayList<Ingredient> ingredients, ArrayList<String> steps) {
    //    this.name = name;
    //    this.time = time;
    //  this.ingredients = ingredients;
    //    this.steps = steps;
    //}

//    public String getName() {
//        return name;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public ArrayList<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public ArrayList<String> getSteps() {
//        return steps;
//    }

    @Override
    public String toString() {
        return
                "\nназвание - " + name +
                "\n<br>время приготовления - " + time +
                "\n<br>ингредиенты - " + ingredients +
                "\n<br>шаги приготовления - " + steps;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Recipe otherRecipe = (Recipe) o;
//        return name.equals(otherRecipe.getName()) && ingredients.equals(otherRecipe.getIngredients());
//    }
//
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, ingredients);
//    }
}
