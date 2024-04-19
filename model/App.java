package model;

import enums.Menu;

import java.util.ArrayList;

public class App {
    public static final ArrayList<User> users = new ArrayList<User>();
    private static User loggedInUser = null;
    private static Menu currentMenu = Menu.LoginMenu;

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        App.loggedInUser = loggedInUser;
    }
}
