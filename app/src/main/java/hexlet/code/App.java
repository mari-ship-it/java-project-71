package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        version = "gendiff 1.0",
        mixinStandardHelpOptions = true,
        sortOptions = false,
        description = "Compares two configuration files and shows a difference.")

final class App implements Callable<Integer> {

    @Parameters(index = "0",
            paramLabel = "filepath1",
            description = "path to first file")
    private String filePath1;

    @Parameters(index = "1",
            paramLabel = "filepath2",
            description = "path to second file")
    private String filePath2;

    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format @|bold [|@ default: stylish]")
    private String format;

    @Option(names = {"-h", "--help"},
            usageHelp = true,
            description = "Show this @|blue help|@ message and exit.")
    private boolean usageHelpRequested;

    @Option(names = {"-V", "--version"},
            versionHelp = true,
            description = "Print version information and exit.")
    private boolean versionInfoRequested;

    @Override
    public Integer call() throws IOException {

        try {
            System.out.println("Differ.generate(filePath1, filePath2)");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
