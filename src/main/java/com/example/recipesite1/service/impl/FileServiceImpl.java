package com.example.recipesite1.service.impl;

import com.example.recipesite1.service.FileService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService {

    @Value("/src/main/resources/recipes.json")
    private String recipeFilePath;

    @Value("recipes.json")
    private String recipeFileName;
    @Value("${ingredients.file.name}")
    private String ingredientFileName;

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(recipeFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveToFile(String json) {
        try {
            Files.writeString(Path.of(recipeFilePath), json);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
