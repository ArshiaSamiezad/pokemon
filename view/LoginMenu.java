package view;

import controller.LoginMenuController;
import enums.LoginMenuCommands;
import enums.ShopMenuCommands;

import com.ahmz.test.tester.Scanner;

import java.util.regex.Matcher;

public class LoginMenu extends AppMenu {
    private final LoginMenuController controller = new LoginMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;

        if ((matcher = LoginMenuCommands.RegisterUser.getMather(input)) != null) {
            System.out.println(controller.register(matcher.group("username"),
                    matcher.group("password"), matcher.group("email")));
        } else if ((matcher = LoginMenuCommands.LoginUser.getMather(input)) != null) {
            System.out.println(controller.login(matcher.group("username"),
                    matcher.group("password")));
        } else if ((matcher = LoginMenuCommands.Exit.getMather(input)) != null) {
            controller.exit();
        } else if ((matcher = LoginMenuCommands.ShowMenu.getMather(input)) != null) {
            System.out.println("login menu");
        } else {
            System.out.println("invalid command");
        }
    }
}
