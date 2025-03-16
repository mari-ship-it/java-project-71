package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.ldap.SortKey;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {

        Path path1 = Paths.get("src", "test", "resources", filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get("src", "test", "resources", filePath2).toAbsolutePath().normalize();

        String json1 = Files.readString(path1).trim();
        String json2 = Files.readString(path2).trim();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(json1, new TypeReference<Map<String, Object>>(){});
        Map<String, Object> map2 = objectMapper.readValue(json2, new TypeReference<Map<String, Object>>(){});

        TreeSet<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        var sortedKeys = keys.stream().sorted().toList();
        StringBuilder genDiff = new StringBuilder();
        genDiff.append("{\n");

        sortedKeys.forEach((key) -> {

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
        });

        genDiff.append("}");
        return genDiff.toString();
    }
}
