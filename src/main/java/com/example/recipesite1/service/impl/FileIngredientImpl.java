package com.example.recipesite1.service.impl;

import com.example.recipesite1.service.FileIngredient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileIngredientImpl implements FileIngredient {
    @Value("${path.to.data.faleIngredient}")
    private String pathFileIngredient;
    @Value("${mame.of.data.faleIngredient}")
    private String fileNameIngredient;

    @Override
    public String readFromFileIngredient() {
        try {
            return Files.readString(Path.of(pathFileIngredient));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveToFileIngredient(String json) {
        try {
            Files.writeString(Path.of(pathFileIngredient), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
