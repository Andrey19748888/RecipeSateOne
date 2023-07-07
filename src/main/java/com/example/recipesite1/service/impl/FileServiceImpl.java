package com.example.recipesite1.service.impl;

import com.example.recipesite1.service.FileService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService {

    @Value("${path.to.data.file}")
    private String filePath;

    @Value("${file.name}")
    private String fileName;

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveToFile(String json) {
        try {
            Files.writeString(Path.of(filePath), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
