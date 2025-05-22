package hexlet.code.formatter;

import hexlet.code.CompareResult;
import hexlet.code.TypeStatus;

import java.util.List;

public class StylishFormatter {

    private static final String PLUS_PREFIX = "  + ";
    private static final String MINUS_PREFIX = "  - ";
    private static final String UNCHANGED_PREFIX = "    ";
    private static final String SYMBOL = ": ";

    public static String format(List<CompareResult> compareResult) {

        StringBuilder buildString = new StringBuilder();
        buildString.append("{\n");
        compareResult.forEach(items -> {

            TypeStatus type = items.getStatus();
            String key = items.getKey();
            Object value = items.getValue();
            Object oldValue = items.getOldValue();

            switch (type) {
                case ADDED:
                    buildString.append(PLUS_PREFIX).append(key).append(SYMBOL).append(value).append("\n");
                    break;
                case DELETED:
                    buildString.append(MINUS_PREFIX).append(key).append(SYMBOL).append(value).append("\n");
                    break;
                case UNCHANGED:
                    buildString.append(UNCHANGED_PREFIX).append(key).append(SYMBOL).append(value).append("\n");
                    break;
                case CHANGED:
                    buildString.append(MINUS_PREFIX).append(key).append(SYMBOL).append(oldValue).append("\n");
                    buildString.append(PLUS_PREFIX).append(key).append(SYMBOL).append(value).append("\n");
                    break;
                default:
            }
        });
        buildString.append("}");

        return buildString.toString();
    }
}
