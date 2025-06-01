package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public final class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {

        String firstContent = readFile(filePath1);
        String secondContent = readFile(filePath2);

        String formatFile1 = getFileFormat(filePath1);
        String formatFile2 = getFileFormat(filePath2);

        Map<String, Object> firstMap = Parser.parse(firstContent, formatFile1);
        Map<String, Object> secondMap = Parser.parse(secondContent, formatFile2);

        List<CompareResult> compareResult = Comparator.compare(firstMap, secondMap);
        return Formatter.format(compareResult, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    static String readFile(String fileName) throws IOException {

        Path path = Paths.get(fileName).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    private static String getFileFormat(String fileName) {

        String[] items = fileName.split("\\.");
        return items[items.length - 1];
    }
}
