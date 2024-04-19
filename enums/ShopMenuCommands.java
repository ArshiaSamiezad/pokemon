package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ShopMenuCommands {
    BuyCard("buy card (?<cardName>\\S*)"),
    SellCard("sell card (?<cardName>\\S*)"),
    ShowMenu("show current menu"),
    Back("back");

    public final String pattern;

    ShopMenuCommands(String pattern) {
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
