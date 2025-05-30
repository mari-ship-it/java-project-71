package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

final class Parser {

    static Map<String, Object> parse(String content, String format) throws JsonProcessingException {

        ObjectMapper mapper = switch (format) {
            case "yaml", "yml" -> new YAMLMapper();
            case "json" -> new ObjectMapper();
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
