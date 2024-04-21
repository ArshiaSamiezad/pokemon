package model;

public class Game {
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private int round;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.activePlayer = player1;
        this.round=1;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getEnemy(){
        if(activePlayer.equals(player1)){
            return player2;
        }
        return player1;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
