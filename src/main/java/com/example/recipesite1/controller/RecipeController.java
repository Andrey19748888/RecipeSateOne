package com.example.recipesite1.controller;


import com.example.recipesite1.model.Recipe;
import com.example.recipesite1.service.impl.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeService;

    @GetMapping
    public String applicationLaunch() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String project() {
        return "Денисов Андрей, \n" +
                "RecipeSite, \n" +
                "05.05.2023, \n" +
                "Описание";
    }

    @GetMapping("/getRecipe")
    public String getRecipe(@RequestParam int id) {
        try {
            return recipeService.getRecipe(id).toString();
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/addRecipe")
    public String addRecipe(@RequestBody Recipe recipe) {
        try {
            recipeService.putRecipe(recipe);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "Рецепт добавлен";
    }

    @DeleteMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam int id) {
        try {
            recipeService.deleteRecipe(id);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "Рецепт удалён";
    }

    @GetMapping("/getAllRecipe")
    public String getAllRecipe() {
        return recipeService.getAllRecipe().toString();
    }

    @PostMapping("/editRecipe")
    public String editRecipe(@RequestParam int id, @RequestBody Recipe recipe) {
        try {
            recipeService.editRecipe(id, recipe);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "Рецепт редактирован";

    }
}
