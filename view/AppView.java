package view;

import enums.Menu;
import model.App;

import com.ahmz.test.tester.Scanner;

public class AppView {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        do {
            App.getCurrentMenu().checkCommand(scanner);
        }while(App.getCurrentMenu() != Menu.ExitMenu);
    }
}
