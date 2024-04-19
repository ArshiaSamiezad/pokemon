package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterValidPatterns {
    // Register User
    UserName("[a-zA-Z_]+"), // NULL: username format is invalid
    PasswordLength("\\S{6,18}"), // NULL: password length too small or short
    PasswordSpecialCharacter("\\S*[@#$^&!]+\\S*"), // NULL: your password must have at least one special character
    PasswordWithEnglishCharacter("[a-zA-Z]\\S+"), // NULL: your password must start with english letters
    EmailAddress("\\S*@[a-z]+\\.com"), // NULL: email format is invalid
    EmailWrongSpecialCharacter("^((?=\\S*\\.\\S*\\.\\S*@\\S+\\.com)|" +
            "(?=\\S*[^a-zA-Z0-9\\.]+\\S*@\\S*\\.com)|" +
            "(?=\\S*@\\S*[^a-z]+\\S*\\.com)|(?=^@\\S*\\.com))\\S*"), // NOT NULL: you can't use special characters
    ;
    public final String pattern;

    RegisterValidPatterns(String pattern) {
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
