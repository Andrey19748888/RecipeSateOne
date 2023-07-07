package com.example.recipesite1.service.impl;

import com.example.recipesite1.model.Ingredient;
import com.example.recipesite1.model.Recipe;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class IngredientServiceImpl implements com.example.recipesite1.service.IngredientService {

    private static int idCounter = 1;
    private HashMap<Integer, Ingredient> map;


    public IngredientServiceImpl() {
        map = new HashMap<>();
         map.put(7, new Ingredient("помидоры", 4, "единиц"));// todo remove this line
    }

    @Override
    public void putIngredient(Ingredient ingredient) {

        if (ingredient == null) {
            throw new RuntimeException("Ингредиент пустой, не добавить");
        }

        if (map.containsValue(ingredient)) {
            throw new RuntimeException("Такой ингредиент уже есть");
        }

        if (ingredient.getName() == null || ingredient.getNumberOfIngredients() == 0 || ingredient.getUnit() == null) {
            throw new RuntimeException("Ингредиент не добавлен. Поля рецепта не могут быть null!");
        }

        map.put(idCounter, ingredient);
        System.out.println(map);
        idCounter++;
    }

    // 1 - ingredient1
    // 2 - ingredient2
    // 3 - ingredient3

    public void editIngredient(int id, Ingredient ingredient) {

        if (ingredient == null) {
            throw new RuntimeException("Ингредиент пустой, не добавить");
        }

        if (ingredient.getName() == null || ingredient.getNumberOfIngredients() == 0 || ingredient.getUnit() == null) {
            throw new RuntimeException("Ингредиент не добавлен. Поля рецепта не могут быть null!");
        }

        if (map.containsValue(ingredient)) {
            throw new RuntimeException("Такой ингредиент уже есть");
        }

        if (map.containsKey(id)) {
            map.put(id, ingredient);
        } else {
            throw new RuntimeException("Ингредиента с таким id нет");
        }

        //
    }

    @Override
    public Ingredient getIngredient(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }
        throw new RuntimeException("Ингредиента с таким id нет");
    }

    @Override
    public void deleteIngredient(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            return;
        }
        throw new RuntimeException("Нет такого инградиента");

    }




    public Collection<Ingredient> getAll() {
        return map.values();
    }



}
