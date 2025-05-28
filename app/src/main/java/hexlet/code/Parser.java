package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

class Parser {

    protected static Map<String, Object> parse(String content, String format) {

        ObjectMapper mapper = switch (format) {
            case "yaml", "yml" -> new YAMLMapper();
            case "json" -> new ObjectMapper();
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };

        try {
            return mapper.readValue(content, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new IllegalStateException("Ошибка при парсинге данных. Причина: " + e.getMessage(), e);
        }
    }
}
