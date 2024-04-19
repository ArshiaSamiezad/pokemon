package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileMenuCommands {
    ShowCoins("show coins"),
    ShowExperience("show experience"),
    ShowStorage("show storage"),
    EquipCard("equip card (?<cardName>\\S*) to my deck"),
    UnequipCard("unequip card (?<cardName>\\S*) from my deck"),
    ShowDeck("show my deck"),
    ShowRank("show my rank"),
    ShowRanking("show ranking"),
    ShowMenu("show current menu"),
    Back("back");

    public final String pattern;

    ProfileMenuCommands(String pattern) {
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
