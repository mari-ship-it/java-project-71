package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AppTest {

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    void testStylishOutput(String inputFormat) throws Exception {
        //String actualResult = Differ.generate(file1, file2, "stylish");
       // assertEquals(actualResult, );
    }
}
