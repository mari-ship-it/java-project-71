package hexlet.code;

import picocli.CommandLine;
//import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true, /*helpCommand = true,*/
        description = "Compares two configuration files and shows a difference.")
final class App implements Runnable {

    //@Parameters(index = "0")
    //private String getHelp;

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
