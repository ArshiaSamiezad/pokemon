package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainMenuCommands {
    ShopMenu("go to shop menu"),
    ProfileMenu("go to profile menu"),
    GameMenu("start new game with (?<username>\\S*)"),
    ShowMenu("show current menu"),
    Logout("logout");

    public final String pattern;

    MainMenuCommands(String pattern) {
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
