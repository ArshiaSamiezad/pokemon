package controller;

import enums.PokemonConditions;
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

    private Pokemon getPokemonByPlaceNumber(Player player, int placeNumber) {
        Pokemon pokemon = null;
        switch (placeNumber) {
            case 0:
                pokemon = player.getActiveCard();
                break;
            case 1:
                pokemon = player.getBenchCard1();
                break;
            case 2:
                pokemon = player.getBenchCard2();
                break;
            case 3:
                pokemon = player.getBenchCard3();
                break;
        }
        return pokemon;
    }

    private void setPokemonByPlaceNumber(Player player, int placeNumber, Pokemon pokemon) {
        switch (placeNumber) {
            case 0:
                player.setActiveCard(pokemon);
                break;
            case 1:
                player.setBenchCard1(pokemon);
                break;
            case 2:
                player.setBenchCard2(pokemon);
                break;
            case 3:
                player.setBenchCard3(pokemon);
                break;
        }
    }

    private void setEnergyByPlaceNumber(Player player, int placeNumber, Energy energy) {
        Pokemon pokemon = getPokemonByPlaceNumber(player, placeNumber);
        if (pokemon.getEnergy1() == null) {
            pokemon.setEnergy1(energy);
            return;
        }
        pokemon.setEnergy2(energy);
    }

    private void printPokemonCondition(String condition) {
        if (condition == null) {
            System.out.println("");
            return;
        }
        System.out.println(condition);
    }

    private void printEnergy(Energy energy) {
        if (energy == null) {
            return;
        }
        System.out.print(energy.getName());
    }

    private boolean cardNameExists(String cardName) {
        for (enums.CardNames name : enums.CardNames.values()) {
            if (name.name.equals(cardName)) {
                return true;
            }
        }
        return false;
    }

    private boolean playerOwnsCard(Player player, String cardName) {
        ArrayList<Card> cards = player.getDeckCards();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(cardName)) {
                return true;
            }
        }
        return false;
    }

    private void putCardPokemon(Player player, int placeNumber, Pokemon pokemon) {
        if (getPokemonByPlaceNumber(player, placeNumber) != null) {
            System.out.println("a pokemon already exists there");
            return;
        }
        setPokemonByPlaceNumber(player, placeNumber, pokemon);
        player.removeFromDeck(pokemon);
    }

    private void putCardEnergy(Player player, int placeNumber, Energy energy) {
        if (getPokemonByPlaceNumber(player, placeNumber) == null) {
            System.out.println("no pokemon in the selected place");
            return;
        }
        if (player.getActiveCard().getEnergy1() != null && player.getActiveCard().getEnergy2() != null) {
            System.out.println("pokemon already has 2 energies");
            return;
        }
        if (player.isPlayedEnergyThisTurn()) {
            System.out.println("you have already played an energy card in this turn");
            return;
        }
        setEnergyByPlaceNumber(player, placeNumber, energy);
        player.removeFromDeck(energy);
        player.setPlayedEnergyThisTurn(true);
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

        Player enemy = game.getEnemy();

        System.out.println(enemy.getUsername() + "'s active card:");
        printActiveCard(enemy);
        System.out.println("");

        System.out.println(enemy.getUsername() + "'s bench:");
        printBench(enemy);
    }

    public void showInfo(int playerType, String placeNumberString) { // playerType 0 for activePlayer 1 for enemy
        int placeNumber = Integer.valueOf(placeNumberString);
        if (placeNumber < 0 || placeNumber > 3) {
            System.out.println("invalid place number");
            return;
        }
        Game game = App.getCurrentGame();
        Player player;
        if (playerType == 0) {
            player = game.getActivePlayer();
        } else {
            player = game.getEnemy();
        }
        Pokemon pokemon = getPokemonByPlaceNumber(player, placeNumber);
        if (pokemon == null) {
            System.out.println(" no pokemon in the selected place");
        }

        System.out.println("pokemon: " + pokemon.getName());

        System.out.print("special condition: ");
        printPokemonCondition(pokemon.getCondition());

        System.out.println("hitpoint: " + pokemon.getHitpoint() + "/" + pokemon.getPower());

        System.out.print("energy 1: ");
        printEnergy(pokemon.getEnergy1());
        System.out.println("");

        System.out.print("energy 2: ");
        printEnergy(pokemon.getEnergy2());
        System.out.println("");
    }

    public void putCard(String cardName, String placeNumberString) {
        Game game = App.getCurrentGame();
        Player activePlayer = game.getActivePlayer();
        Card card = activePlayer.getDeckCardByName(cardName);
        int placeNumber = Integer.valueOf(placeNumberString);

        if (!cardNameExists(cardName)) {
            System.out.println("card name is invalid");
            return;
        }
        if (!playerOwnsCard(activePlayer, cardName)) {
            System.out.println("you don't have the selected card");
            return;
        }
        if (placeNumber < 0 || placeNumber > 3) {
            System.out.println("invalid place number");
            return;
        }
        boolean isPokemon = false;
        if (card instanceof Pokemon) {
            isPokemon = true;
        }
        if (isPokemon) {
            putCardPokemon(activePlayer, placeNumber, (Pokemon) card);
        } else {
            putCardEnergy(activePlayer, placeNumber, (Energy) card);
        }
        System.out.println("card put successful");
    }

    public void substituteCard(String benchNumberString) {
        Game game = App.getCurrentGame();
        Player activePlayer = game.getActivePlayer();
        int benchNumber = Integer.valueOf(benchNumberString);
        if (benchNumber < 1 || benchNumber > 3) {
            System.out.println("invalid bench number");
            return;
        }
        Pokemon benchCard = getPokemonByPlaceNumber(activePlayer, benchNumber);

        if (benchCard == null) {
            System.out.println("no pokemon in the selected place");
            return;
        }
        Pokemon activeCard = getPokemonByPlaceNumber(activePlayer, 0);
        if (activeCard.getCondition().equals(PokemonConditions.Sleeping.conidition)) {
            System.out.println("active pokemon is sleeping");
            return;
        }
        Pokemon tempCard = activeCard;
        setPokemonByPlaceNumber(activePlayer, 0, benchCard);
        setPokemonByPlaceNumber(activePlayer, benchNumber, tempCard);
        System.out.println("substitution successful");
    }

    public void endTurn() {
        Game game = App.getCurrentGame();
        Player currentActivePlayer = game.getActivePlayer();
        currentActivePlayer.setPlayedEnergyThisTurn(false);
        if (currentActivePlayer.equals(game.getPlayer2())) {
            game.setRound(game.getRound() + 1);
        }
        // TODO: Do passive
        // TODO: Win or lose
    }

    public void executeActionWithTarget(String target) {
        Game game = App.getCurrentGame();
        Player player = game.getActivePlayer();
        Pokemon activePokemon = player.getActiveCard();
        if (activePokemon == null) {
            System.out.println("no active pokemon");
            return;
        }
        Player enemy = game.getEnemy();
        int placeNumber = Integer.valueOf(target);
        Pokemon targetPokemon;
        if (activePokemon instanceof Ducklett){
            targetPokemon=getPokemonByPlaceNumber(enemy, placeNumber);
        }
        else if (activePokemon instanceof Rowlet){
            targetPokemon=getPokemonByPlaceNumber(player, placeNumber);
        }
        else {
            System.out.println("invalid action");
            return;
        }

        if (((placeNumber < 0 || placeNumber > 3) && (activePokemon instanceof Ducklett)) ||
                ((placeNumber < 1 || placeNumber > 3) && (activePokemon instanceof Rowlet))) {
            System.out.println("invalid target number");
            return;
        }
        if (targetPokemon == null) {
            System.out.println("no pokemon in the selected place");
            return;
        }
        if (activePokemon.getCondition().equals("sleeping")) {
            System.out.println("active pokemon is sleeping");
            return;
        }
        activePokemon.doAction(game, player, enemy, targetPokemon);
        activePokemon.doPassive(game, player, enemy, targetPokemon);

        System.out.println("action executed successfully");
        System.out.println(enemy.getUsername() + "'s turn");
        endTurn();
    }
}
