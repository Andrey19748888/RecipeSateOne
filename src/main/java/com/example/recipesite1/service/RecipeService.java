package com.example.recipesite1.service;

import com.example.recipesite1.model.Recipe;

public interface RecipeService {
    void putRecipe(Recipe recipe);

    Recipe getRecipe(int id);

    void deleteRecipe(int id);
}
