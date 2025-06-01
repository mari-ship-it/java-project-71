package hexlet.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static hexlet.code.TypeStatus.ADDED;
import static hexlet.code.TypeStatus.DELETED;
import static hexlet.code.TypeStatus.UNCHANGED;
import static hexlet.code.TypeStatus.CHANGED;

final class Comparator {

    static List<CompareResult> compare(Map<String, Object> firstMap, Map<String, Object> secondMap) {

        List<CompareResult> result = new LinkedList<>();
        var keys = new TreeSet<>(firstMap.keySet());
        keys.addAll(secondMap.keySet());

        keys.forEach(key -> {

            var firstValue = firstMap.get(key);
            var secondValue = secondMap.get(key);

            if (!firstMap.containsKey(key)) {
                result.add(new CompareResult(ADDED, key, secondValue, firstValue));

            } else if (!secondMap.containsKey(key)) {
                result.add(new CompareResult(DELETED, key, firstValue, secondValue));

            } else if (firstMap.get(key) != null && firstMap.get(key).equals(secondMap.get(key))) {
                result.add(new CompareResult(UNCHANGED, key, firstValue, firstValue));

            } else {
                result.add(new CompareResult(CHANGED, key, secondValue, firstValue));
            }
        });
        return result;
    }
}
