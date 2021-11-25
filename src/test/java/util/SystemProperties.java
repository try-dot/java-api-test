package util;

public class SystemProperties {

    public static final String APPLICATION_URL = System.getProperty("application.url");
    public static final String UI_URL = System.getProperty("ui.url");

    private SystemProperties() {
    }

}
