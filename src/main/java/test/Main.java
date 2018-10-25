package test;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;

public class Main {

    public static void main(String[] args) throws Exception {
        configureLogger();
        AccountServer.getInstance().start();
        AccountServer.getInstance().getServer().join();
    }

    public static void configureLogger() {
        LogManager.resetConfiguration();
        String LOGGER_PATTERN = "%d{dd.MM HH:mm:ss.SSS} %-5p [%-25c{1}] %m%n";
        ConsoleAppender console = new ConsoleAppender();
        console.setLayout(new PatternLayout(LOGGER_PATTERN));
        console.setThreshold(Priority.INFO);
        console.activateOptions();
        org.apache.log4j.Logger.getLogger("test").addAppender(console);
    }
}
