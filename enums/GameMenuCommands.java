    package enums;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public enum GameMenuCommands {
        ShowTable("show table"),
        ShowMyInfo("show my info (?<placeNumber>[0-9]+)"),
        ShowEnemyInfo("show enemy info (?<placeNumber>[0-9]+)"),
        PutCard("put card (?<cardName>\\S*) to (?<placeNumber>[0-9]+)"),
        SubstituteActiveCard("substitute active card with bench (?<benchNumber>[0-9]+)"),
        EndTurn("end turn"),
        ExecuteActionWithTarget("execute action -t (?<target>\\S*)"),
        ShowMenu("show current menu"),
        ExecuteActionNoTarget("execute action");

        public final String pattern;

        GameMenuCommands(String pattern) {
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
