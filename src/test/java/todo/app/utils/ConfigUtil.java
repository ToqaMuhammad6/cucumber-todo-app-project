package todo.app.utils;

import java.io.*;
import java.util.Properties;

public class ConfigUtil {

    public static Properties readConfig(String path) throws IOException {

        File propFile = new File(path);
        FileInputStream is= new FileInputStream(propFile);

        Properties prop= new Properties();
        prop.load(is);
        is.close();

        return prop;
    }
}
