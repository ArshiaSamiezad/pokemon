package view;

import controller.MainMenuController;
import enums.MainMenuCommands;
import enums.ShopMenuCommands;

import com.ahmz.test.tester.Scanner;
import java.util.regex.Matcher;

public class MainMenu extends AppMenu {
    private final MainMenuController controller = new MainMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;

        if ((matcher = MainMenuCommands.ShopMenu.getMather(input)) != null) {
            controller.goToShop();
        } else if ((matcher = MainMenuCommands.ProfileMenu.getMather(input)) != null) {
            controller.goToProfile();
        } else if ((matcher = MainMenuCommands.GameMenu.getMather(input)) != null) {
            String result = controller.goToGame(matcher.group("username"));
            if (result != null) {
                System.out.println(result);
            }
        } else if ((matcher = MainMenuCommands.Logout.getMather(input)) != null) {
            controller.logout();
        }else if ((matcher = MainMenuCommands.ShowMenu.getMather(input)) != null) {
            System.out.println("main menu");
        } else {
            System.out.println("invalid command");
        }
    }
}
