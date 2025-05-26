package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompareResult {

    private TypeStatus status;
    private String key;
    private Object value;
    private Object oldValue;
}
