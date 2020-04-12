package fr.yohann.bsim.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Configuration
{
    private static final Logger log = LogManager.getLogManager().getLogger("Configuration");
    private static final Configuration instance = new Configuration();

    private static Properties properties;

    private Configuration() {
        try {
            File configFolder = new File(getUserHome() + "/Ocpp201Config");
            if (configFolder.exists() && configFolder.isDirectory()) {
                File configFile = new File(getUserHome() + "/Ocpp201Config/" + "config.json");
                if (configFile.exists() && configFile.isFile()) {
                } else {
                    if (!configFile.createNewFile()) {
                        throw new IllegalStateException("Can't create file : " + configFile.getPath());
                    }
                }

            } else {
                if (!configFolder.mkdirs()) {
                    throw new IllegalStateException("Couldn't create dir: " + getUserHome() + "/Ocpp201Config");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void updateProperties(Properties properties) {
        File configFile = new File(getUserHome() + "/Ocpp201Config/config.json");
        try {
            if (properties == null) {
                properties = new Properties();
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String contents = gson.toJson(properties, Properties.class);
            Path file = Paths.get(configFile.toURI());
            Files.writeString(file, contents);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void updateProperties() {
        updateProperties(getProperties());
    }

    private static Properties DefaultConfig() {
        return new Properties("", "", "", "", "");
    }

    private static String getUserHome() {
        String userHome = System.getProperty("user.home");
        return userHome.replace("\\", "/");
    }
    public static Configuration getInstance() { return instance; }

    public static Properties getProperties() { return properties; }

}
