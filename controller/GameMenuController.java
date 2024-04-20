package controller;

import model.*;
import model.Cards.*;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class GameMenuController {
    Matcher matcher;

    private void changeActivePlayer() {
        Game game = App.getCurrentGame();
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        if (player1.equals(game.getActivePlayer())) {
            game.setActivePlayer(player2);
            return;
        }
        game.setActivePlayer(player1);
    }

    private void printPokemoneWithEnergy(Pokemon pokemon) {
        if (pokemon == null) {
            System.out.println("");
        } else {
            System.out.print(pokemon.getName() + "|");
            if (pokemon.getEnergy1() == null) { // Assuming that energy1 cant be empty when we have energy2
                System.out.println("|");
            } else {
                System.out.print(pokemon.getEnergy1().getName() + "|");
                if (pokemon.getEnergy2() == null) {
                    System.out.println("");
                } else {
                    System.out.println(pokemon.getEnergy2().getName());
                }
            }
        }
    }

    private void printActiveCard(Player player) {
        Pokemon activeCard = player.getActiveCard();
        printPokemoneWithEnergy(activeCard);
    }

    private void printHand(Player player) {
        System.out.println("your hand:");
        ArrayList<Card> deckCards = player.getDeckCards();
        for (int i = 0; i < deckCards.size(); i++) {
            System.out.println((i + 1) + "." + deckCards.get(i).getName());
        }
    }

    private void printBench(Player player) {
        System.out.print("1.");
        printPokemoneWithEnergy(player.getBenchCard1());
        System.out.print("2.");
        printPokemoneWithEnergy(player.getBenchCard2());
        System.out.print("3.");
        printPokemoneWithEnergy(player.getBenchCard3());
    }

    public void startGame(Player player1, Player player2) {
        Game game = new Game(player1, player2);
        App.setCurrentGame(game);
    }

    public void endGame() {
        App.setCurrentGame(null);
    }


    public void showTable() {
        Game game = App.getCurrentGame();

        int round = game.getRound();
        System.out.println("round " + round);

        Player activePlayer = game.getActivePlayer();
        System.out.println("your active card:");
        printActiveCard(activePlayer);
        System.out.println("");

        printHand(activePlayer);
        System.out.println("");

        System.out.println("your bench:");
        printBench(activePlayer);
        System.out.println("");

        Player enemy;
        if (activePlayer.equals(game.getPlayer1())) {
            enemy = game.getPlayer2();
        } else {
            enemy = game.getPlayer1();
        }

        System.out.println(enemy.getUsername() + "'s active card:");
        printActiveCard(enemy);
        System.out.println("");

        System.out.println(enemy.getUsername() + "'s bench:");
        printBench(enemy);
    }

    public void showInfo(Player player, int placeNumber){
        if(placeNumber<0 || placeNumber>3){
            System.out.println("invalid place number");
            return;
        }
        switch(placeNumber){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
