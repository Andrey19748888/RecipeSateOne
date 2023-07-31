package com.example.recipesite1.service.impl;

import com.example.recipesite1.model.Recipe;
import com.example.recipesite1.service.FileService;
import com.example.recipesite1.service.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static int idCounter = 1;

    private HashMap<Integer, Recipe> recipes;
    private FileService fileService;    // todo прописать этот же сервис в IngredientServiceImpl


    @PostConstruct
    public void init() {
        fileService = new FileServiceImpl();
        System.out.println(recipes);    // todo стереть эту строку
        readFromFile();     // импорт всего нашего файла в HashMap recipes  todo added
        System.out.println(recipes);    // todo стереть эту строку
//        recipes = new HashMap<>();    // todo стереть эту строку
//        recipes.put(5, new Recipe("spaghetti", 10, null, null)); // todo remove this line
//        saveToFile();       // todo у;рат,

    }

    public void saveToFile() {  // это сдесь
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(recipes);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        String json = fileService.readFromFile();
        try {
            recipes = mapper.readValue(json, HashMap.class);        // todo added
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putRecipe(Recipe recipe) {

        if (recipe == null) {
            throw new RuntimeException("Рецепт пустой, не добавить");
        }

        if (recipes.containsValue(recipe)) {
            throw new RuntimeException("Такой рецепт уже есть");
        }

        if (recipe.getName() == null || recipe.getIngredients() == null || recipe.getSteps() == null ||
                recipe.getTime() == 0 || recipe.getSteps().isEmpty() || recipe.getIngredients().isEmpty()) {
            throw new RuntimeException("Рецепт не добавлен. \nПоля рецепта не могут быть null! \nСписок ингредиентов и шагов не могут быть пустыми");
        }

        recipes.put(idCounter, recipe);
        System.out.println(recipes);    // todo убрать
        idCounter++;
        saveToFile(); //aaaaaa
    }

    @Override
    public Recipe getRecipe(int id) {
        if (recipes.containsKey(id)) {
            return recipes.get(id);
        }
        throw new RuntimeException("Рецепта с таким id нет");
    }

    @Override
    public void deleteRecipe(int id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
            saveToFile();
            return;
        }
        throw new RuntimeException("Рецепта с таким id нет");
    }

    public Collection<Recipe> getAllRecipe() {
        return recipes.values();
    }

    public void editRecipe(int id, Recipe recipe) {
        if (recipe == null) {
            throw new RuntimeException("Рецепт пустой, не добавить");
        }

        if (recipe.getName() == null || recipe.getIngredients() == null || recipe.getSteps() == null || recipe.getTime()
                == 0) {
            throw new RuntimeException("Рецепт не отредактирован. Поля рецепта не могут быть null!");
        }

        if (recipes.containsValue(recipe)) {
            throw new RuntimeException("Такой рецепт уже есть");
        }

        if (recipes.containsKey(id)) {
            recipes.put(id, recipe);
            saveToFile(); // todo aaaaz
        } else {
            throw new RuntimeException("Рецепта с таким id нет");
        }

    }


}