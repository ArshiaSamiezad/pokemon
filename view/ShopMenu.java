package view;

import controller.ShopMenuController;
import enums.ProfileMenuCommands;
import enums.ShopMenuCommands;

import com.ahmz.test.tester.Scanner;
import java.util.regex.Matcher;

public class ShopMenu extends AppMenu{
    private final ShopMenuController controller = new ShopMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;

        if((matcher = ShopMenuCommands.BuyCard.getMather(input))!=null){
            System.out.println(controller.buyCard(matcher.group("cardName")));
        }
        else if((matcher = ShopMenuCommands.SellCard.getMather(input))!=null){
            System.out.println(controller.sellCard(matcher.group("cardName")));
        }
        else if ((matcher = ShopMenuCommands.Back.getMather(input)) != null) {
            controller.back();
        }
        else if ((matcher = ShopMenuCommands.ShowMenu.getMather(input)) != null) {
            System.out.println("shop menu");
        }else {
            System.out.println("invalid command");
        }
    }
}
