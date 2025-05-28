package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) {

        String contentFile1;
        String contentFile2;

        try {
            contentFile1 = readFile(filePath1);
            contentFile2 = readFile(filePath2);
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка ввода-вывода при чтении файлов");
        }
        String formatFile1 = getFileFormat(filePath1);
        String formatFile2 = getFileFormat(filePath2);

        Map<String, Object> mapFile1 = Parser.parse(contentFile1, formatFile1);
        Map<String, Object> mapFile2 = Parser.parse(contentFile2, formatFile2);

        List<CompareResult> compareResult = Compare.compare(mapFile1, mapFile2);

        return Formatter.format(compareResult, format);
    }

    public static String generate(String filePath1, String filePath2) {
        return generate(filePath1, filePath2, "stylish");
    }

    protected static String readFile(String fileName) throws IOException {

        Path path = Paths.get(fileName).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    private static String getFileFormat(String fileName) {
        String[] items = fileName.split("\\.");
        return items[items.length - 1];
    }
}
