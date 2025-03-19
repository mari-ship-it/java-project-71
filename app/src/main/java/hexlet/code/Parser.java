package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Parser {

    private static Path getPath(String fileName) {

        return Paths.get("src", "test", "resources", "fixtures", fileName).toAbsolutePath().normalize();
    }

    protected static String readFile(String fileName) {

        Path path = getPath(fileName);
        try {
            return Files.readString(path).trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
