package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;

import static java.awt.Color.red;
import static picocli.CommandLine.Help.Ansi.Style.fg;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true, sortOptions = false,
        description = "Compares two configuration files and shows a difference.")
final class App implements Runnable {

    @Parameters(index = "0",  paramLabel = "filepath1", description = "path to first file")
    private File filePath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private File filePath2;

    @Option(names = {"-f", "--format"},paramLabel = "format",
            description = "output format @|bold [|@ default: stylish]", defaultValue = "stylish")
    String format;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this @|blue help|@ message and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    public static void main(String[] args) {

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        //System.out.println("Hello World!");
    }

    @Override
    public void run() {
    }
}
