package hexlet.code.formatter;

import hexlet.code.CompareResult;
import hexlet.code.TypeStatus;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    public static String format(List<CompareResult> compareResult) {

        StringBuilder stringBuilder = new StringBuilder();

        compareResult.forEach(items -> {

            TypeStatus type = items.getStatus();
            String key = items.getKey();
            Object value = isCondition(items.getValue());
            Object oldValue = isCondition(items.getOldValue());

                switch (type) {
                    case TypeStatus.ADDED:
                        stringBuilder.append("Property '").append(key).append("' was ").append("added with value: ")
                                .append(value).append("\n");
                        break;
                    case TypeStatus.DELETED:
                        stringBuilder.append("Property '").append(key).append("' was ").append("removed").append("\n");
                        break;
                    case TypeStatus.CHANGED:
                        stringBuilder.append("Property '").append(key).append("' was ").append("updated. From ")
                            .append(oldValue).append(" to ").append(value).append("\n");
                        break;
                    default:
                }
        });
        return stringBuilder.toString();
    }

    public static Object isCondition(Object value) {
        if (value instanceof Map || value instanceof List) {
            return value = "[complex value]";
        }
        return value;
    }
}
