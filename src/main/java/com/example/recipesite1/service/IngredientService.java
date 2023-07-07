package com.example.recipesite1.service;

import com.example.recipesite1.model.Ingredient;

public interface IngredientService {
    void putIngredient(Ingredient ingredient);

    Ingredient getIngredient(int id);

    void deleteIngredient(int id);
}
