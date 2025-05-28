package hexlet.code;

import hexlet.code.formatter.JsonFormatter;
import hexlet.code.formatter.PlainFormatter;
import hexlet.code.formatter.StylishFormatter;

import java.util.List;

final class Formatter {

    private Formatter() {
        throw new IllegalStateException("Formatter class cannot be instantiated");
    }

    static String format(List<CompareResult> compareResult, String format) {

        return switch (format) {
            case "stylish" -> StylishFormatter.format(compareResult);
            case "plain" -> PlainFormatter.format(compareResult);
            case "json" -> JsonFormatter.format(compareResult);
            default -> throw new UnsupportedOperationException("Format " + format + " not supported");
        };
    }
}
