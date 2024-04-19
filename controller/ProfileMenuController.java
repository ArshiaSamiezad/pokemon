package controller;

import enums.*;
import model.*;
import model.Cards.Card;
import model.Cards.Pokemon;

import java.util.*;

public class ProfileMenuController {
    public int showCoins() {
        User user = App.getLoggedInUser();
        return user.getCoins();
    }

    public int showExperience() {
        User user = App.getLoggedInUser();
        return user.getExperience();
    }

    public void showStorage() {
        User user = App.getLoggedInUser();
        ArrayList<Card> storageCards = user.getStorageCards();
        for (int i = 0; i < storageCards.size(); i++) {
            Card card = storageCards.get(i);
            System.out.println((i + 1) + "." + card.getType() + " " + card.getName() + " " + card.getBuyValue()); //+" "+card
        }
    }

    public String equipCard(String cardName) {
        User user = App.getLoggedInUser();
        for (enums.CardNames name : enums.CardNames.values()) {
            if (name.name.equals(cardName)) {
                Card unequippedCard = user.getUnequippedCardByName(cardName);
                if (unequippedCard == null) {
                    return "you don't have this type of card";
                }
                Card deckCard = user.getDeckCardByName(cardName);
                if (user.getDeckCardsCount() >= 12) {
                    return "your deck is already full";
                }
                if (deckCard != null && (deckCard instanceof Pokemon)) {
                    return "you have already added this type of pokemon to your deck";
                }
                user.addToDeck(unequippedCard);
                user.removeFromUnequipped(unequippedCard);
                return "card " + cardName + " equipped to your deck successfully";
            }
        }
        return "card name is invalid";
    }

    public String unequipCard(String cardName) {
        User user = App.getLoggedInUser();
        for (enums.CardNames name : enums.CardNames.values()) {
            if (name.name.equals(cardName)) {
                Card deckCard = user.getDeckCardByName(cardName);
                if (deckCard == null) {
                    return "you don't have this type of card in your deck";
                }
                user.removeFromDeck(deckCard);
                user.addToUnequipped(deckCard);
                return "card " + cardName + " unequipped from your deck successfully";
            }
        }
        return "card name is invalid";
    }

    public void showDeck() {
        User user = App.getLoggedInUser();
        ArrayList<Card> deckCards = user.getDeckCards();
        for (int i = 0; i < deckCards.size(); i++) {
            System.out.println((i + 1) +"."+ deckCards.get(i).getName()); //+" "+deckCards.get(i)
        }
    }

    public int showRank() {
        User user = App.getLoggedInUser();
        ArrayList<User> users = App.users;
        ArrayList<Integer> ranks = new ArrayList<Integer>();
        getRanking(users, ranks);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                return i+1;
            }
        }
        throw new ArithmeticException("User not in list");
    }

    public void printRanking() {
        ArrayList<User> users = App.users;
        ArrayList<Integer> ranks = new ArrayList<Integer>();
        getRanking(users, ranks);
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i+1) + ".username:" + users.get(i).getUsername() + " experience:" + users.get(i).getExperience());
        }
    }

    public void back() {
        App.setCurrentMenu(Menu.MainMenu);
    }

    private void getRanking(ArrayList<User> users, ArrayList<Integer> ranks) {
        sortUsers(users);
        int rank = 0;
        int consequentArtistsWithSameRank = 0;
        for (int i = 0; i < users.size(); i++) {
            if (i > 0) {
                if (users.get(i).getExperience() == users.get(i - 1).getExperience()) {
                    consequentArtistsWithSameRank++;
                } else {
                    rank = rank + 1 + consequentArtistsWithSameRank;
                    consequentArtistsWithSameRank = 0;
                }

            } else {
                rank++;
            }
            ranks.add(rank);
        }
    }

    private void sortUsers(ArrayList<User> users) {
        // Sort by experience
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                User userI = users.get(i);
                User userJ = users.get(j);
                if (userI.getExperience() < userJ.getExperience()) {
                    users.set(i, userJ);
                    users.set(j, userI);
                }
            }
        }

        // Sort by username
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                User userI = users.get(i);
                User userJ = users.get(j);
                if (!(userI.getExperience()==(userJ.getExperience()))) {
                    break;
                }
                if (userI.getUsername().compareTo(userJ.getUsername()) > 0) {
                    users.set(i, userJ);
                    users.set(j, userI);
                }
            }
        }
    }


}
