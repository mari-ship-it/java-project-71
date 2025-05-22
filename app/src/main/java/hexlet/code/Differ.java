package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static hexlet.code.TypeStatus.ADDED;
import static hexlet.code.TypeStatus.CHANGED;
import static hexlet.code.TypeStatus.UNCHANGED;
import static hexlet.code.TypeStatus.DELETED;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        String contentFile1 = readFile(filePath1);
        String contentFile2 = readFile(filePath2);

        String formatFile1 = getFileFormat(filePath1);
        String formatFile2 = getFileFormat(filePath2);

        Map<String, Object> mapFile1 = Parser.parse(contentFile1, formatFile1);
        Map<String, Object> mapFile2 = Parser.parse(contentFile2, formatFile2);

        List<CompareResult> compareResult = compare(mapFile1, mapFile2);

        return Formatter.format(compareResult, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    protected static String readFile(String fileName) throws IOException {

        String namePath = "src/test/resources/" + fileName;
        Path path = Paths.get(namePath).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    private static String getFileFormat(String fileName) {
        //возвращает расширение файла (json, yml, yaml)
        String[] items = fileName.split("\\.");
        return items[items.length - 1];
    }

    public static List<CompareResult> compare(Map<String, Object> mapFile1,
                                                    Map<String, Object> mapFile2) {

        LinkedList<CompareResult> result = new LinkedList<>();
        var keys = new TreeSet<>(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        keys.forEach(key -> {

            var value1 = mapFile1.get(key);
            var value2 = mapFile2.get(key);

            if (!mapFile1.containsKey(key)) {
                result.add(new CompareResult(ADDED, key, value2, value1));

            } else if (!mapFile2.containsKey(key)) {
                result.add(new CompareResult(DELETED, key, value1, value2));

            } else if (mapFile1.get(key) != null && mapFile1.get(key).equals(mapFile2.get(key))) {
                result.add(new CompareResult(UNCHANGED, key, value1, value1));

            } else {
                result.add(new CompareResult(CHANGED, key, value2, value1));
            }
        });
        return result;
    }
}
