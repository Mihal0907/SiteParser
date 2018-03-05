package ua.artcode.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IOUtils {

    public static void writeInto (String path, String content, boolean append) throws IOException {
        try(Writer writer = new FileWriter(path, append)){
            writer.write(content);
            writer.flush();
        }
    }
}
