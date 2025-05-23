package hexlet.code;

import hexlet.code.formatter.JsonFormatter;
import hexlet.code.formatter.PlainFormatter;
import hexlet.code.formatter.StylishFormatter;

import java.util.List;

public class Formatter {

    public static String format(List<CompareResult> compareResult, String format) {

        try {
            return switch (format) {
                case "stylish" -> StylishFormatter.format(compareResult);
                case "plain" -> PlainFormatter.format(compareResult);
                case "json" -> JsonFormatter.format(compareResult);
                default -> throw new UnsupportedOperationException("Format " + format + " not supported");
            };
        } catch (Exception e) {
            throw new UnsupportedOperationException("Ошибка при форматировании");
        }
    }
}
