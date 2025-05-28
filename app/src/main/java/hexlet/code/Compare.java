package hexlet.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static hexlet.code.TypeStatus.ADDED;
import static hexlet.code.TypeStatus.DELETED;
import static hexlet.code.TypeStatus.UNCHANGED;
import static hexlet.code.TypeStatus.CHANGED;

public class Compare {

    public static List<CompareResult> compare(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {

        LinkedList<CompareResult> result = new LinkedList<>();
        var keys = new TreeSet<>(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        keys.forEach(key -> {

            var value1 = mapFile1.get(key);
            var value2 = mapFile2.get(key);

            if (!mapFile1.containsKey(key)) {
                result.add(new CompareResult(ADDED, key, value2, value1));

            } else if (!mapFile2.containsKey(key)) {
                result.add(new CompareResult(DELETED, key, value1, value2));

            } else if (mapFile1.get(key) != null && mapFile1.get(key).equals(mapFile2.get(key))) {
                result.add(new CompareResult(UNCHANGED, key, value1, value1));

            } else {
                result.add(new CompareResult(CHANGED, key, value2, value1));
            }
        });
        return result;
    }
}
