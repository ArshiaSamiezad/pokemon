package view;

import controller.ProfileMenuController;
import enums.LoginMenuCommands;
import enums.ProfileMenuCommands;
import enums.ShopMenuCommands;

import com.ahmz.test.tester.Scanner;

import java.util.regex.Matcher;

public class ProfileMenu extends AppMenu {
    private final ProfileMenuController controller = new ProfileMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;
        if ((matcher = ProfileMenuCommands.ShowCoins.getMather(input)) != null) {
            System.out.println("number of coins:" + controller.showCoins());
        } else if ((matcher = ProfileMenuCommands.ShowExperience.getMather(input)) != null) {
            System.out.println("experience:" + controller.showExperience());
        } else if ((matcher = ProfileMenuCommands.ShowStorage.getMather(input)) != null) {
            controller.showStorage();
        } else if ((matcher = ProfileMenuCommands.EquipCard.getMather(input)) != null) {
            System.out.println(controller.equipCard(matcher.group("cardName")));
        } else if ((matcher = ProfileMenuCommands.UnequipCard.getMather(input)) != null) {
            System.out.println(controller.unequipCard(matcher.group("cardName")));
        } else if ((matcher = ProfileMenuCommands.ShowDeck.getMather(input)) != null) {
            controller.showDeck();
        } else if ((matcher = ProfileMenuCommands.ShowRank.getMather(input)) != null) {
            System.out.println("your rank:" + controller.showRank());
        } else if ((matcher = ProfileMenuCommands.ShowRanking.getMather(input)) != null) {
            controller.printRanking();
        } else if ((matcher = ProfileMenuCommands.Back.getMather(input)) != null) {
            controller.back();
        } else if ((matcher = ProfileMenuCommands.ShowMenu.getMather(input)) != null) {
            System.out.println("profile menu");
        } else {
            System.out.println("invalid command");
        }
    }
}
