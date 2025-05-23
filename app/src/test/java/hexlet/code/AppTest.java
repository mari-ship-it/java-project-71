package hexlet.code;

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
        expectedStylish = Differ.readFile("src/test/resources/fixtures/stylish.yaml");
        expectedPlain = Differ.readFile("src/test/resources/fixtures/plain.yaml");
        expectedJson = Differ.readFile("src/test/resources/fixtures/json.json");
    }

    @Test
    void testJsonWithStylishOutput() {

        String actual = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json");
        assertEquals(expectedStylish, actual);
    }

    @Test
    void testWithStylishOutput() {

        String actual2 = Differ.generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml");
        assertEquals(expectedStylish, actual2);
    }

    @Test
    void testJsonWithPlainOutput() {

        String actual = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json", "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    void testYamlWithPlainOutput() {

        String actual = Differ.generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml", "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    void testJsonWithJsonOutput() {

        String actual = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json", "json");
        assertEquals(expectedJson, actual);
    }

    @Test
    void testYamlWithJsonOutput() {

        String actual = Differ.generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml", "json");
        assertEquals(expectedJson, actual);
    }
}
