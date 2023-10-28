# Mancala

## Inspiration
I recently learned how to play this board game and I wanted to make it as a text-based game.

## What it does
This Youtube video briefly explains the rules: https://www.youtube.com/watch?v=OX7rj93m6o8

It is a simple and strategic 2-player game. Players take turns with the goal of obtaining the most stones when one side (of either player) is empty (no stones left). The pits at the ends of the board, known as capture pits, are the score for each player.
The game starts with 4 stones in each pocket. 
On a turn, a player removes all of the stones in one pocket and then deposits them one at a time in the following pockets, including their own capture pit (but not the opponent's capture pit). 
If a player's turn has a last stone landed in their own empty pocket, they collect the opponent's stones from the pocket across from their own. 

![Mancala image](https://cf.ltkcdn.net/family/images/std-xs/314371-340x219-mancala-rules-01.jpg)

## How we built it
With Java.

## Challenges we ran into
Initially, the board ordering/position of pockets and the traversal of pockets was not correct. I had to make an array of pockets that goes (n -1) -> 0 for player 1 and (n-1) -> 0 for player 2 to implement the traversal. However, the visual representation of the board has to be (n -1) -> 0 for player 1 and 0 -> (n-1) for player 2.

## Accomplishments that we're proud of
- The board is adjustable and not fixed to the usual 6 pockets/pits. 
- I got to apply OPP concepts such as aggregation to this project.

## What we learned
How to play one of the oldest board games and creating + putting together 4 different Java classes to simulate the game. 

## What's next for Mancala
- Maybe make a GUI for it
- Allow the user to change the initial amount of stones in a pit/pocket
