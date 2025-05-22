package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatter.JsonFormatter;
import hexlet.code.formatter.PlainFormatter;
import hexlet.code.formatter.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<CompareResult> compareResult, String format) throws JsonProcessingException {

        return switch (format) {
            case "stylish" -> StylishFormatter.format(compareResult);
            case "plain" -> PlainFormatter.format(compareResult);
            case "json" -> JsonFormatter.format(compareResult);
            default -> throw new IllegalArgumentException("Format " + format + " not supported");
        };
    }
}
