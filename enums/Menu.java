package enums;

import view.*;

import com.ahmz.test.tester.Scanner;

public enum Menu {
    GameMenu(new GameMenu()),
    LoginMenu(new LoginMenu()),
    MainMenu(new MainMenu()),
    ProfileMenu(new ProfileMenu()),
    ShopMenu(new ShopMenu()),
    ExitMenu(new ExitMenu());


    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }
}
