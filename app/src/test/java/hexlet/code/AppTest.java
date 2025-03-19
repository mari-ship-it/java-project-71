
package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private static String expected;

    @BeforeAll
    public static void beforeAll() {
        expected = Parser.readFile("result.json");
    }

    public static AppTest createAppTest() {
        return new AppTest();
    }

    @Test
    public void testDiffGen() throws Exception {

        System.out.println(expected);
        String actual = generate("file1.json", "file2.json");
        assertEquals(expected, actual);
    }

    @Test
    public void testYml() throws Exception {

        String actual2 = Differ.generate("filepath1.yml", "filepath2.yml");
        assertEquals(expected, actual2);
    }
}
