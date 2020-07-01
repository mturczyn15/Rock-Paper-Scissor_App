package com.kodilla.rps.uix;

import com.kodilla.rps.model.*;

import java.util.Scanner;

public class SimpleUserInterface implements UserInterface {

    private final Scanner SCANNER = new Scanner(System.in);


    @Override
    public void printMenu() {

        System.out.println("Available moves: " + "\n 1- play rock."
                + "\n 2- play paper." + "\n 3- play scissors." + "\n x- end of game." + "\n n- new game.");
    }

    @Override
    public void printShortMenu() {

        System.out.println("Short menu: " + "\n x- end of game." + "\n n- new game.");
    }

    @Override
    public String getMove() {
        System.out.println("Give your Move: ");
        String move = SCANNER.next();
        if (!move.equals("1") && !move.equals("2") && !move.equals("3") && !move.equals("x") && !move.equals("n")) {
            System.out.println("Bad move try once again.");
        }
        return move;
    }

    @Override
    public String getUserName() {
        System.out.println("What's your name? ");
        return SCANNER.next();
    }

    @Override
    public int getRoundCount() {

        System.out.println("Give count of win rounds: ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("This isn't number. Please give number");
            SCANNER.next();
        }
        return SCANNER.nextInt();
    }

    @Override
    public void informRound(Move playerMove, Move enemyMove, RoundResult result) {
        if (result == RoundResult.EXIT) {
            System.out.println("You exit the game.");
        } else if (result == RoundResult.NEW) {
            System.out.println("You start new game. ");
        } else {
            System.out.println("Your move is: " + playerMove + ". Enemy move is: " + enemyMove + ". Round result is: " + result);
        }
    }

    @Override
    public void informScore(Statistics statistics) {
        System.out.println("Your points:" + statistics.getWins() + " Enemy points: " + statistics.getLoses());
    }

    @Override
    public void informGame(GameDefinition definition, Statistics statistics) {

        if (statistics.whoWins() == Winner.DRAW) System.out.println("It's a draw.");
        if (statistics.whoWins() == Winner.ENEMY)
            System.out.println(definition.getUsername() + " you played to: " + definition.getRounds() + " Enemy is the winner. You have " + statistics.getWins() + ". Enemy has " + definition.getRounds() + " points.");
        if (statistics.whoWins() == Winner.PLAYER)
            System.out.println(definition.getUsername() + " you played to: " + definition.getRounds() + " You are the winner. You have " + statistics.getWins() + ". Enemy has " + statistics.getLoses() + " points.");
    }

    @Override
    public boolean confirmExit() {

        System.out.println("Do you really want to exit? " + " Y-yes N-no ");
        return SCANNER.next().equals("y");
    }

    @Override
    public boolean confirmNewGame() {
        System.out.println("Do you really want to start new game? " + " Y-yes N-no ");
        return SCANNER.next().equals("y");
    }

    @Override
    public void printRound(int number) {
        System.out.println("This is round number: " + number);
    }

    @Override
    public void thankYou(String username) {
        System.out.println("Thank You " + username + " for game.");
    }
}
