package ua.service;

import com.google.gson.Gson;
import jakarta.servlet.ServletInputStream;
import ua.model.Developer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HandleBodyUtil {

    private static Gson gson = new Gson();

    public static  <T> T getModelFromStream(InputStream in, Class<T> returnType){
        T model = null;
        try (InputStream inputStream = in;
             Scanner scanner = new Scanner(inputStream)) {
            String jsonStr = scanner.nextLine();
             model = gson.fromJson(jsonStr, returnType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
}
