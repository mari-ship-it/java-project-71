
package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testDiffGen() throws JsonProcessingException {

        String expected = Utils.readFile("result.json");
        System.out.println(expected);
        String actual = Differ.generate("file1.json", "file2.json");
        assertEquals(expected, actual);
    }
}
