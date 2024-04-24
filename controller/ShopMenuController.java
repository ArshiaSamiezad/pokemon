package controller;

import enums.CardNames;
import enums.Menu;
import model.*;
import model.Cards.*;

public class ShopMenuController {

    public String buyCard(String cardName) {
        User user = App.getLoggedInUser();
        int balance = user.getCoins();
        Card card = null;

        if (CardNames.Dragonite.name.equals(cardName)) card = new Dragonite();
        if (CardNames.Tepig.name.equals(cardName)) card = new Tepig();
        if (CardNames.Lugia.name.equals(cardName)) card = new Lugia();
        if (CardNames.Ducklett.name.equals(cardName)) card = new Ducklett();
        if (CardNames.Pineco.name.equals(cardName)) card = new Pineco();
        if (CardNames.Rowlet.name.equals(cardName)) card = new Rowlet();
        if (CardNames.PinkEnergy.name.equals(cardName)) card = new PinkEnergy();
        if (CardNames.YellowEnergy.name.equals(cardName)) card = new YellowEnergy();

        if (card == null) {
            return "card name is invalid";
        }

        if (balance < card.getBuyValue()) {
            return "not enough coin to buy " + cardName;
        }

        user.addToStorage(card);
        user.addToUnequipped(card);
        user.setCoins(balance - card.getBuyValue());
        return "card " + cardName + " bought successfully";
    }

    public String sellCard(String cardName) {
        User user = App.getLoggedInUser();
        int balance = user.getCoins();
        Card card = null;

        if (CardNames.Dragonite.name.equals(cardName)) card = new Dragonite();
        if (CardNames.Tepig.name.equals(cardName)) card = new Tepig();
        if (CardNames.Lugia.name.equals(cardName)) card = new Lugia();
        if (CardNames.Ducklett.name.equals(cardName)) card = new Ducklett();
        if (CardNames.Pineco.name.equals(cardName)) card = new Pineco();
        if (CardNames.Rowlet.name.equals(cardName)) card = new Rowlet();
        if (CardNames.PinkEnergy.name.equals(cardName)) card = new PinkEnergy();
        if (CardNames.YellowEnergy.name.equals(cardName)) card = new YellowEnergy();

        if (card == null) {
            return "card name is invalid";
        }

        card = null;

        card = user.getStorageCardByName(cardName);
        if (card == null) {
            return "you don't have this type of card for sell";
        }

        user.removeFromUnequipped(card);
        user.removeFromDeck(card);
        user.removeFromStorage(card);
        user.setCoins(balance + card.getSellValue());
        return "card " + cardName + " sold successfully";
    }

    public void back() {
        App.setCurrentMenu(Menu.MainMenu);
    }
}
