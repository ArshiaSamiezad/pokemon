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

        }
        else if(((matcher = GameMenuCommands.ShowEnemyInfo.getMather(input)))!=null){

        }
        else if(((matcher = GameMenuCommands.PutCard.getMather(input)))!=null){

        }
        else if(((matcher = GameMenuCommands.SubstituteActiveCard.getMather(input)))!=null){

        }
        else if(((matcher = GameMenuCommands.EndTurn.getMather(input)))!=null){

        }
        else if(((matcher = GameMenuCommands.ExecuteActionWithTarget.getMather(input)))!=null){

        }
        else if(((matcher = GameMenuCommands.ExecuteActionNoTarget.getMather(input)))!=null){

        }
        else{
            System.out.println("invalid command");
        }
    }
}
