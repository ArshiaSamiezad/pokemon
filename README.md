# Pokemon game

This project is an offline pokemon game designed to be played with another player.

## Features

- **Login Menu:** To login or register a new user.
- **Profile Menu:** To check the details of the current user and choose the playing deck.
- **Shop Menu:** You can buy or sell your pokemon cards here.
- **Main Menu:** You can enter other menus from here.
- **Game Menu:** Game will be played in this menu.

## Installation:

Just run main.java. Java 17 or higher is needed.

## Commands:
- **General commands:**
```java
show current menu
```
In shop or profile menus:
```java
back
```
In main menu:
```java
logout
```
In login menu:
```java
exit
```

**Bellow are the commands for each menu.**

## Login Menu:

- **Registering a new user**:
```java
register username <username> password <password> email <email>
```
*Note: Player will be registered with a starting 300 coins and 0 experience and will be taken back to login menu.*

- **Loging in:**
```java
login username <username> password <password>
```

## Main Menu:

- **To enter shop or profile menus:**
```java
go to shop menu
go to profile menu
```

- **Starting a new game:**
```java
start new game with <username>
```
*Note: Each player must have 12 cards in their deck, and the enemy player username must be valid.*

## Profile Menu:

- **To check details of the logged in user, we have:**
```java
show coins
show experience
show storage
show my deck
show my rank
show ranking
```

- **Equiping a card from your storage to your deck:**
```java
equip card <card name> to my deck
```

- **To de-equip your card from your deck to storage:**
```java
unequip card <card name> from my deck
```

## Shop Menu:

- **For buying cards, use this table and command:**
```java
buy card <card name>
```

|     Pokemon     | Value (Coin) |
|:---------------:|:------------:|
|    Dragonite    |      10      |
|      Tepig      |      13      |
|      Lugia      |      11      |
|     Ducklett    |      15      |
|      Pineco     |       9      |
|      Rowlet     |      12      |
|  Pink (energy)  |       5      |
| Yellow (energy) |       5      |

- **For selling cards, use this table and command:**
```java
sell card <card name>
```

|     Pokemon     | Value (Coin) |
|:---------------:|:------------:|
|    Dragonite    |       8      |
|      Tepig      |      10      |
|      Lugia      |       9      |
|     Ducklett    |      11      |
|      Pineco     |       7      |
|      Rowlet     |       9      |
|  Pink (energy)  |       3      |
| Yellow (energy) |       3      |

## Game Menu:

- **Each pokemon has a certain class and passive abilities:**

| Class |                            Passive Ability                           |
|:-----:|:--------------------------------------------------------------------:|
|  Fire |              Target pokemon will burn in the next round.             |
| Water |                      Resistant against burning.                      |
| Plant | Passive shield with 15 hitpoints, and will be refreshed every round. |

- **Each pokemon has a certain active ability:**

|  Pokemon  |                                       Active Ability                                      |
|:---------:|:-----------------------------------------------------------------------------------------:|
| Dragonite |                             Attacks the active enemy pokemon.                             |
|   Tepig   | Attacks the active pokemon with full power and bench pokemons with 0.2 of its full power. |
|   Lugia   |          Attacks the active pokemon and makes them unconcious for the next round.         |
|  Ducklett |              Attacks the targeted (Active or bench) pokemon and disables it.              |
|   Pineco  |                                       Heals itself.                                       |
|   Rowlet  |                              Heals the targeted ally pokemon.                             |

- **Each pokemon has a certain maximum hitpoint and power:**

|  Pokemon  |                                       Active Ability                                      |
|:---------:|:-----------------------------------------------------------------------------------------:|
| Dragonite |                             Attacks the active enemy pokemon.                             |
|   Tepig   | Attacks the active pokemon with full power and bench pokemons with 0.2 of its full power. |
|   Lugia   |          Attacks the active pokemon and makes them unconcious for the next round.         |
|  Ducklett |              Attacks the targeted (Active or bench) pokemon and disables it.              |
|   Pineco  |                                       Heals itself.                                       |
|   Rowlet  |                              Heals the targeted ally pokemon.                             |

- **Each pokemon has a weakness from each class, and a resistance for each pokemon:**

|  Pokemon  |                                       Active Ability                                      |
|:---------:|:-----------------------------------------------------------------------------------------:|
| Dragonite |                             Attacks the active enemy pokemon.                             |
|   Tepig   | Attacks the active pokemon with full power and bench pokemons with 0.2 of its full power. |
|   Lugia   |          Attacks the active pokemon and makes them unconcious for the next round.         |
|  Ducklett |              Attacks the targeted (Active or bench) pokemon and disables it.              |
|   Pineco  |                                       Heals itself.                                       |
|   Rowlet  |                              Heals the targeted ally pokemon.                             |

- **Each pokemon can have upto 2 energy cards attached to it:**

| Energy type | Pink | Yellow |
|:-----------:|:----:|:------:|
|     Fire    |   1  |    1   |
|    Water    | 1.05 |    1   |
|    Plant    | 1.15 |   1.2  |

*Note: Each energy card affects the power of attack.*

## How to play:

- Each player has a 12 card deck that isn't visible to the enemy.
- Each player has a bench that can hold upto 3 pokemons, and an active card place that can hold 1 pokemon. If a pokemon is placed into the bench or active place from deck, it will be removed from the deck and won't be in the players deck after the game has finished. In other words, playing a pokemon means losing it after the game, whether dead or not. Bench and active places are visible to the enemy.
- Active card index is 0, and bench card indexes are from 1 to 3.
- A player loses if and only if the active pokemon place is empty after playing their turn.
- First player is the player who started the game.

## Game Commands:

```java
show table
show my info <place number>
show enemy info <place number>
put card <card name> to <place number>
substitute active card with bench <bench number>
execute action -t <target>
```
