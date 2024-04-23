package view;

import controller.GameMenuController;

import com.ahmz.test.tester.Scanner;
import enums.GameMenuCommands;

import java.util.regex.Matcher;

public class GameMenu extends AppMenu{
    private final GameMenuController controller = new GameMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;

        if(((matcher = GameMenuCommands.ShowTable.getMather(input)))!=null){
            controller.showTable();
        }
        else if(((matcher = GameMenuCommands.ShowMyInfo.getMather(input)))!=null){
            controller.showInfo(0,matcher.group("placeNumber"));
        }
        else if(((matcher = GameMenuCommands.ShowEnemyInfo.getMather(input)))!=null){
            controller.showInfo(1,matcher.group("placeNumber"));
        }
        else if(((matcher = GameMenuCommands.PutCard.getMather(input)))!=null){
            controller.putCard(matcher.group("cardName"), matcher.group("placeNumber"));
        }
        else if(((matcher = GameMenuCommands.SubstituteActiveCard.getMather(input)))!=null){
            controller.substituteCard(matcher.group("benchNumber"));
        }
        else if(((matcher = GameMenuCommands.EndTurn.getMather(input)))!=null){
            controller.endTurn();
        }
        else if(((matcher = GameMenuCommands.ExecuteActionWithTarget.getMather(input)))!=null){
            controller.executeActionWithTarget(matcher.group("target"));
        }
        else if(((matcher = GameMenuCommands.ExecuteActionNoTarget.getMather(input)))!=null){
            controller.executeActionWithoutTarget();
        }
        else if(((matcher = GameMenuCommands.ShowMenu.getMather(input)))!=null){
            System.out.println("game menu");
        }
        else{
            System.out.println("invalid command");
        }
    }
}
