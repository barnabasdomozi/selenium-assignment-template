import java.io.FileInputStream;
import java.util.Properties;

// This class was written by AI

public class ConfigReader {

    static Properties props = new Properties();

    public static void loadConfig() throws Exception {
        FileInputStream fis = new FileInputStream("config.properties");
        props.load(fis);
    }

    public static String getKey(String key) {
        return props.getProperty(key);
    }
}
