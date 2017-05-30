package converterMain;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import converter.Converter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                PrintWriter writer = new PrintWriter("C:\\Users\\Грег\\Desktop\\output.txt")) {
            List<String> text = Files.readAllLines(Paths.get("C:\\Users\\Грег\\Desktop\\table.txt"));
            String newText = Converter.convertToHTML(text);
            writer.write(newText);
        }
    }
}
