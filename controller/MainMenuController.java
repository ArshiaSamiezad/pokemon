package controller;

import enums.Menu;
import model.*;

public class MainMenuController {
    public void goToShop() {
        App.setCurrentMenu(Menu.ShopMenu);
    }

    public void goToProfile() {
        App.setCurrentMenu(Menu.ProfileMenu);
    }

    public String goToGame(String username) {
        User user = User.getUserByUsername(username);
        if (user == null) {
            return "username is incorrect";
        }
        if (App.getLoggedInUser().getDeckCardsCount() < 12) {
            return App.getLoggedInUser().getUsername() + " has no 12 cards in deck";
        }
        if (user.getDeckCardsCount() < 12) {
            return user.getUsername() + " has no 12 cards in deck";
        }

        App.setCurrentMenu(Menu.GameMenu);
        startGame(new Player(App.getLoggedInUser()),new Player(user));
        return null;
    }

    private void startGame(Player player1, Player player2) {
        Game game = new Game(player1,player2);
        App.setCurrentGame(game);
    }

    public void logout(){
        App.setCurrentMenu(Menu.LoginMenu);
    }
}
