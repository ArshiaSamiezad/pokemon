package model;

import model.Cards.Card;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private int coins;
    private int experience;
    private ArrayList<Card> deckCards = new ArrayList<Card>();
    private ArrayList<Card> unequippedCards = new ArrayList<Card>();
    private ArrayList<Card> storageCards = new ArrayList<Card>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.coins = 300;
        this.experience = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public static User getUserByUsername(String username){
        for(User user : App.users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public Card getStorageCardByName(String cardName){
        for(int i=0;i<storageCards.size();i++){
            if(storageCards.get(i).getName().equals(cardName)){
                return storageCards.get(i);
            }
        }
        return null;
    }

    public Card getDeckCardByName(String cardName){
        for(int i=0;i<deckCards.size();i++){
            if(deckCards.get(i).getName().equals(cardName)){
                return deckCards.get(i);
            }
        }
        return null;
    }

    public Card getUnequippedCardByName(String cardName){
        for(int i=0;i<unequippedCards.size();i++){
            if(unequippedCards.get(i).getName().equals(cardName)){
                return unequippedCards.get(i);
            }
        }
        return null;
    }

    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

    public ArrayList<Card> getStorageCards() {
        return storageCards;
    }

    public ArrayList<Card> getUnequippedCards() {
        return unequippedCards;
    }

    public void setDeckCards(ArrayList<Card> deckCards) {
        this.deckCards = deckCards;
    }

    public void setUnequippedCards(ArrayList<Card> unequippedCards) {
        this.unequippedCards = unequippedCards;
    }

    public void setStorageCards(ArrayList<Card> storageCards) {
        this.storageCards = storageCards;
    }

    public int getDeckCardsCount(){
        return deckCards.size();
    }

    public int getStorageCardsCount(){
        return storageCards.size();
    }
    public int getUnequippedCardsCount(){
        return unequippedCards.size();
    }

    public void addToDeck(Card card){
        deckCards.add(card);
    }

    public void addToStorage(Card card){
        storageCards.add(card);
    }
    public void addToUnequipped(Card card){
        unequippedCards.add(card);
    }

    public void removeFromDeck(Card card){
        deckCards.remove(card);
    }

    public void removeFromStorage(Card card){
        storageCards.remove(card);
    }
    public void removeFromUnequipped(Card card){
        unequippedCards.remove(card);
    }
}
