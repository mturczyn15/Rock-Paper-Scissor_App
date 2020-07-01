package com.kodilla.rps.engine;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;

public class RoundResolver {

    public RoundResult resolve(Move playerMove, Move enemyMove) {

        if (playerMove == enemyMove) return RoundResult.DRAW;
        if (playerMove == Move.PAPER && enemyMove == Move.ROCK) return RoundResult.WIN;
        if (playerMove == Move.ROCK && enemyMove == Move.PAPER) return RoundResult.LOSE;
        if (playerMove == Move.ROCK && enemyMove == Move.SCISSORS) return RoundResult.WIN;
        if (playerMove == Move.SCISSORS && enemyMove == Move.ROCK) return RoundResult.LOSE;
        if (playerMove == Move.PAPER && enemyMove == Move.SCISSORS) return RoundResult.LOSE;
        if (playerMove == Move.EXIT) return RoundResult.EXIT;
        if (playerMove == Move.NEW) return RoundResult.NEW;
        return RoundResult.WIN;
    }
}
