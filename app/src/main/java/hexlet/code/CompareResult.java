package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompareResult {

    TypeStatus status;
    String key;
    Object value;
    Object oldValue;
}
