package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    static void beforeAll() throws IOException {
        expectedStylish = Differ.readFile("stylish.yaml");
        expectedPlain = Differ.readFile("plain.yaml");
        expectedJson = Differ.readFile("json.json");
    }

    @Test
    void testJsonWithStylishOutput() throws Exception {

        String actual = Differ.generate("file1.json", "file2.json");
        assertEquals(expectedStylish, actual);
    }

    @Test
    void testYamlWithStylishOutput() throws Exception {

        String actual2 = Differ.generate("file1.yaml", "file2.yaml");
        assertEquals(expectedStylish, actual2);
    }

    @Test
    void testJsonWithPlainOutput() throws Exception {

        String actual = Differ.generate("file1.json", "file2.json", "plain");
        Assertions.assertEquals(expectedPlain, actual);
    }

    @Test
    void testYamlWithPlainOutput() throws Exception {

        String actual = Differ.generate("file1.yaml", "file2.yaml", "plain");
        Assertions.assertEquals(expectedPlain, actual);
    }

    @Test
    void testJsonWithJsonOutput() throws Exception {

        String actual = Differ.generate("file1.json", "file2.json", "json");
        assertEquals(expectedJson, actual);
    }

    @Test
    void testYamlWithJsonOutput() throws Exception {

        String actual = Differ.generate("file1.yaml", "file2.yaml", "json");
        assertEquals(expectedJson, actual);
    }
}
