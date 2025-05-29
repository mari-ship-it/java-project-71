package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;
    private static final String PATH_TO_FILE = "src/test/resources/fixtures/";

    private static String readFileTest(String fileName) throws IOException {

        Path path = Paths.get(PATH_TO_FILE + fileName).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    @BeforeAll
    static void beforeAll() throws IOException {

        expectedStylish = readFileTest("stylish.yaml");
        expectedPlain = readFileTest("plain.yaml");
        expectedJson = readFileTest("json.json");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    void testDefaultOutput(String inputFormat) {

        String file1 = PATH_TO_FILE + "file1." + inputFormat;
        String file2 = PATH_TO_FILE + "file2." + inputFormat;
        String actual = Differ.generate(file1, file2);
        assertEquals(expectedStylish, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    void testPlainOutput(String inputFormat) {

        String file1 = PATH_TO_FILE + "file1." + inputFormat;
        String file2 = PATH_TO_FILE + "file2." + inputFormat;
        String actual = Differ.generate(file1, file2, "plain");
        assertEquals(expectedPlain, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    void testJsonOutput(String inputFormat) {

        String file1 = PATH_TO_FILE + "file1." + inputFormat;
        String file2 = PATH_TO_FILE + "file2." + inputFormat;
        String actual = Differ.generate(file1, file2, "json");
        assertEquals(expectedJson, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    void testStylishOutput(String inputFormat) {

        String file1 = PATH_TO_FILE + "file1." + inputFormat;
        String file2 = PATH_TO_FILE + "file2." + inputFormat;
        String actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expectedStylish, actual);
    }
}
