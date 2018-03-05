package ua.artcode;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JSONUtils {
    private static Gson gson = new Gson();

    public static<T> T fromJson(String json, Class<T> tClass){
        return gson.fromJson(json, tClass);
    }

    public static String toJson (Object src){
        return gson.toJson(src);
    }

    public static void writeListIntoFile (String path, List<?> list){
        try(Writer writer = new FileWriter(path, false)){
            for (Object o : list){
                writer.write(gson.toJson(o));
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static<T> List<T> readListFromFile(String path, Class<T> objClass) throws IOException {
        return Files.readAllLines(Paths.get(path))
                .stream()
                .map(line -> gson.fromJson(line, objClass))
                .collect(Collectors.toList());
    }


}
