package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Objects;
import java.util.Properties;


public class PropertyReader {

    private static final Logger log = LoggerFactory.getLogger(PropertyReader.class);
    private static String testEnvironment = System.getProperty("test");
    private static Properties props;

    public static String getProperty(String prop) {
        String systemPropertyValue = System.getProperty(prop);

        try {
            if (systemPropertyValue == null && props.getProperty(prop) == null) {
                throw new RuntimeException();
            }
        } catch (Exception var3) {
            log.error("Property " + prop + " not found");
        }

        return systemPropertyValue != null ? systemPropertyValue : props.getProperty(prop);
    }

    private PropertyReader() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        testEnvironment = testEnvironment != null ? testEnvironment : "dev";
        InputStream fileName = PropertyReader.class.getClassLoader().getResourceAsStream("environment/" + testEnvironment + ".yml");
        log.info("Loading " + testEnvironment + " env properties");

        try {
            props = new Properties();
            props.load(new InputStreamReader(Objects.requireNonNull(fileName, "Properties file is null")));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}
