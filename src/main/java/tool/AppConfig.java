
package tool;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties props;

    static {
        props = new Properties();
        try {
            InputStream resourceAsStream = AppConfig.class.getClassLoader().getResourceAsStream("config/app_config.properties");
            if (resourceAsStream == null) {
                throw new IllegalArgumentException("config/app_config.properties file not found!");
            } else {
                props.load(resourceAsStream);
                resourceAsStream.close();
            }
        } catch (Exception ex) {
            System.out.println("read config/app_config.properties error, system exit." + ex.getMessage());
            System.exit(-1);
        }
    }
    public static String get(String key) {
        return System.getProperty(key, props.getProperty(key, ""));
    }

    public static String get(String key, String defaultValue) {
        return System.getProperty(key, props.getProperty(key, defaultValue));
    }
}
