package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public final class Differ {

    private Differ() {
        throw new IllegalStateException("Differ class cannot be instantiated");
    }

    public static String generate(String filePath1, String filePath2, String format) {

        String contentFile1;
        String contentFile2;

        contentFile1 = readFile(filePath1);
        contentFile2 = readFile(filePath2);

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

    private static String readFile(String fileName) {
        try {
            Path path = Paths.get(fileName).toAbsolutePath().normalize();
            return Files.readString(path).trim();
        } catch (IOException e) {
            throw new IllegalArgumentException("Ошибка при чтении файла: " + fileName + ". Причина: "
                    + e.getMessage(), e);
        }
    }

    private static String getFileFormat(String fileName) {
        String[] items = fileName.split("\\.");
        return items[items.length - 1];
    }
}
