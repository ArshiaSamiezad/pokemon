package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommands {
    RegisterUser("[\\s]*register[\\s]*" +
            "username[\\s]*(?<username>\\S+?)[\\s]*" +
            "password[\\s]*(?<password>\\S+?)[\\s]*" +
            "email[\\s]*(?<email>\\S+?)[\\s]*"),
    LoginUser("[\\s]*login[\\s]*" +
            "username[\\s]*(?<username>\\S+?)[\\s]*" +
            "password[\\s]*(?<password>\\S+?)[\\s]*"),
    ShowMenu("show current menu"),
    Exit("exit");

    public final String pattern;

    LoginMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMather(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);

        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
