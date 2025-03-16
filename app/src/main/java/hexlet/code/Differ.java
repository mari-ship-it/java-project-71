package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {

    public static void generate(String filePath1, String filePath2) throws Exception {

        Path path1 = Paths.get("src", "test", "resources", filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get("src", "test", "resources", filePath2).toAbsolutePath().normalize();

        String json1 = Files.readString(path1).trim();
        String json2 = Files.readString(path2).trim();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(json1, new TypeReference<Map<String, Object>>(){});
        Map<String, Object> map2 = objectMapper.readValue(json2, new TypeReference<Map<String, Object>>(){});

        System.out.println(map1);
        System.out.println(map2);
    }
}
