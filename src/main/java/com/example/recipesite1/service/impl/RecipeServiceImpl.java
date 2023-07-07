package com.example.recipesite1.service.impl;

import com.example.recipesite1.model.Recipe;
import com.example.recipesite1.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static int idCounter = 1;

    private HashMap<Integer, Recipe> map;


    public RecipeServiceImpl() {
        map = new HashMap<>();
        map.put(5, new Recipe("spaghetti", 10, null, null)); // todo remove this line
    }

    @Override
    public void putRecipe(Recipe recipe) {

        if (recipe == null) {
            throw new RuntimeException("Рецепт пустой, не добавить");
        }

        if (map.containsValue(recipe)) {
            throw new RuntimeException("Такой рецепт уже есть");
        }

        if (recipe.getName() == null || recipe.getIngredients() == null || recipe.getSteps() == null ||
                recipe.getTime() == 0 || recipe.getSteps().isEmpty() || recipe.getIngredients().isEmpty()) {
            throw new RuntimeException("Рецепт не добавлен. \nПоля рецепта не могут быть null! \nСписок ингредиентов и шагов не могут быть пустыми");
        }

        map.put(idCounter, recipe);
        System.out.println(map);
        idCounter++;
    }

    @Override
    public Recipe getRecipe(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }
        throw new RuntimeException("Рецепта с таким id нет");
    }

    @Override
    public void deleteRecipe(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            return;
        }
        throw new RuntimeException("Рецепта с таким id нет");
    }

    public Collection<Recipe> getAllRecipe() {
        return map.values();
    }

    public void editRecipe(int id, Recipe recipe) {
        if (recipe == null) {
            throw new RuntimeException("Рецепт пустой, не добавить");
        }

        if (recipe.getName() == null || recipe.getIngredients() == null || recipe.getSteps() == null || recipe.getTime()
                == 0) {
            throw new RuntimeException("Рецепт не отредактирован. Поля рецепта не могут быть null!");
        }

        if (map.containsValue(recipe)) {
            throw new RuntimeException("Такой рецепт уже есть");
        }

        if (map.containsKey(id)) {
            map.put(id, recipe);
        } else {
            throw new RuntimeException("Рецепта с таким id нет");
        }

    }


}