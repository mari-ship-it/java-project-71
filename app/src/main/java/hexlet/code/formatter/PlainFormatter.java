package hexlet.code.formatter;

import hexlet.code.CompareResult;
import hexlet.code.TypeStatus;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    private static final String PROPERTY = "Property '";

    public static String format(List<CompareResult> compareResult) {

        StringBuilder stringBuilder = new StringBuilder();

        compareResult.forEach(items -> {

            TypeStatus type  = items.getStatus();
            String key = items.getKey();
            Object value = isCondition(items.getValue1());
            Object oldValue = isCondition(items.getValue2());

            switch (type) {
                case TypeStatus.ADDED:
                    stringBuilder.append(PROPERTY).append(key).append("' was added with value: ")
                            .append(value).append("\n");
                    break;
                case TypeStatus.DELETED:
                    stringBuilder.append(PROPERTY).append(key).append("' was removed").append("\n");
                    break;
                case TypeStatus.CHANGED:
                    stringBuilder.append(PROPERTY).append(key).append("' was updated. From ")
                            .append(oldValue).append(" to ").append(value).append("\n");
                    break;
                case TypeStatus.UNCHANGED:
                    break;
                default: throw new IllegalArgumentException("Unknown status type: " + type);
            }
        });
        return stringBuilder.toString().trim();
    }

    public static Object isCondition(Object value) {
        if (value instanceof Map || value instanceof List) {
            value = "[complex value]";
        } else if (value instanceof String) {
            value = "'" + value + "'";
        }
        return value;
    }
}
