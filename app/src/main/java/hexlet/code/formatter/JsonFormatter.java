package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.CompareResult;

import java.util.List;

public class JsonFormatter {

    public static String format(List<CompareResult> compareResult) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(compareResult);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Ошибка обработки JSON: " + e.getMessage(), e);
        }
    }
}
