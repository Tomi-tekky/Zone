import com.zone.utils.ConfigManager;

public class Test {

    public static void main(String[] args) {
        ConfigManager config = new ConfigManager("src/test/resources/config.properties");

        String baseUrl = config.getProperty("url");
        String Firstname = config.getProperty("firstname");
        String password = config.getProperty("password");

        System.out.println("Base URL: " + baseUrl);
        System.out.println("Username: " + Firstname);
        System.out.println("Password: " + password);
    }
}