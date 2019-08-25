package com.securepay.webauto.config;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private static final String PROPERTY_FILE_PATH = "config/config.properties";
    private static final String BROWSER_TYPE = "browser_type";
    private static final String DRIVER_APPENDIX = "_driver";
    private static final String DRIVER_PATH_APPENDIX = "_driver_path";
    private static final String SECUREPAY_URL = "securepay_url";
    private static final String SECUREPAY_CONTACT_US = "securepay_contact_us";
    private static final String IMPLICITLY_WAIT = "implicitly_wait";
    private static final String EXPLICITLY_WAIT = "explicitly_wait";
    private static final String PAGELOAD_TIMEOUT = "pageload_timeout";
    private static ConfigFileReader configFileReader = null;
    private Properties properties;

    private ConfigFileReader() {
        properties = new Properties();
        InputStream input = ConfigFileReader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_PATH);
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigFileReader getInstance() {
        if (configFileReader == null) {
            synchronized (ConfigFileReader.class) {
                if (configFileReader == null) {
                    configFileReader = new ConfigFileReader();
                }
            }
        }
        return configFileReader;
    }

    public String getBrowserType() {
        return properties.getProperty(BROWSER_TYPE);
    }

    public String getDriverType() {
        return properties.getProperty(getBrowserType().toLowerCase() + DRIVER_APPENDIX);
    }

    public String getDriverPath() {
        return properties.getProperty(getBrowserType().toLowerCase() + DRIVER_PATH_APPENDIX);
    }

    public String getSecurePayURL() {
        return properties.getProperty(SECUREPAY_URL);
    }

    public String getSecurePayContactUs() {
        return properties.getProperty(SECUREPAY_CONTACT_US);
    }

    public int getImplicitlyWait() {
        return Integer.parseInt(properties.getProperty(IMPLICITLY_WAIT));
    }

    public int getExplicitlyWait() {
        return Integer.parseInt(properties.getProperty(EXPLICITLY_WAIT));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty(PAGELOAD_TIMEOUT));
    }
}