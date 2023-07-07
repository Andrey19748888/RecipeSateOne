package com.example.recipesite1.controller;

import com.example.recipesite1.model.Ingredient;
import com.example.recipesite1.service.impl.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    @Autowired
    IngredientServiceImpl ingredientService;

//    @GetMapping      todo remove this comment
//    public String applicationLaunch() {
//        return "Приложение запущено";
//    }
//
//    @GetMapping("/info")
//    public String project() {
//        return "Денисов Андрей, \n" +
//                "RecipeSite, \n" +
//                "05.05.2023, \n" +
//                "Описание";
//    }

    @GetMapping("/getIngredient")
    public String getIngredient(@RequestParam int id) {
        try {
            return ingredientService.getIngredient(id).toString();
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/addIngredient")
    public String addIngredient(@RequestBody Ingredient ingredient) {
        try {
            ingredientService.putIngredient(ingredient);
        } catch (RuntimeException e) {
            return e.getMessage();
        }

        return "Ингредиент добавлен";
    }

    @DeleteMapping("/deleteIngredient")
    public String deleteIngredient(@RequestParam int id) {
        try {
            ingredientService.deleteIngredient(id);
        } catch (RuntimeException e) {
            return  e.getMessage();
        }
        return "Ингредиент удален";
    }

    @PostMapping("/editIngredient")
    public String editIngredient(@RequestParam int id, @RequestBody Ingredient ingredient) {
        try {
            ingredientService.editIngredient(id, ingredient);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "Ингредиент редактирован";
    }



    @GetMapping("/getAllIngredients")
    public String getAll() {
        return ingredientService.getAll().toString();

//        Collection ingredients = ingredientService.getAll();
//                   ingredients.toString();

    }

}
