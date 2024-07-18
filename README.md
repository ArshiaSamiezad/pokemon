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

