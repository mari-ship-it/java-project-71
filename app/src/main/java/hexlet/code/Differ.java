package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;
import java.util.TreeSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


public class Differ {

    private static Map<String, Object> getMap(String fileName) throws Exception {

        String formatFile = fileName.substring(fileName.lastIndexOf('.') + 1);

        ObjectMapper mapper = switch (formatFile) {
            case "yaml", "yml" -> new YAMLMapper();
            case "json" -> new ObjectMapper();
            default -> throw new IllegalStateException("Unexpected value: " + formatFile);
        };

        return mapper.readValue(Parser.readFile(fileName),
                new TypeReference<Map<String, Object>>() { });
    }

    public static String generate(String filePath1, String filePath2) throws Exception {

        Map<String, Object> map1 = getMap(filePath1);
        Map<String, Object> map2 = getMap(filePath2);

        TreeSet<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        var sortedKeys = keys.stream().sorted().toList();

        StringBuilder genDiff = new StringBuilder();
        genDiff.append("{\n");

        for (String key : sortedKeys) {

            if (!map1.containsKey(key)) {

                genDiff.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (!map2.containsKey(key)) {

                var current = map1.get(key);
                genDiff.append("  - ").append(key).append(": ").append(current).append("\n");
            } else if (map1.get(key).equals(map2.get(key))) {

                genDiff.append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else {

                genDiff.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                genDiff.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }

        genDiff.append("}");
        return genDiff.toString();
    }
}
