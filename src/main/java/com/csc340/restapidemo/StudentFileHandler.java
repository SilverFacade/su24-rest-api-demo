package com.csc340.restapidemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentFileHandler {
    private static final String FILE_PATH = "students.json";
    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<Integer, Student> readFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return mapper.readValue(file, new TypeReference<Map<Integer, Student>>() {});
            } else {
                return new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static void writeToFile(Map<Integer, Student> students) {
        try {
            mapper.writeValue(new File(FILE_PATH), students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}