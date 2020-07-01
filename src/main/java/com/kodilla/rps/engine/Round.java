package com.kodilla.rps.engine;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;
import com.kodilla.rps.strategy.EnemyStrategy;
import com.kodilla.rps.strategy.PlayerStrategy;
import com.kodilla.rps.uix.UserInterface;

public class Round {

    private final int number;
    private final Statistics statistics;
    private final PlayerStrategy playerStrategy;
    private final EnemyStrategy enemyStrategy;
    private final RoundResolver roundResolver;
    private final UserInterface userInterface;

    public Round(Statistics statistics, UserInterface userInterface) {
        this.number = statistics.getRounds() + 1;
        this.statistics = statistics;
        this.userInterface = userInterface;
        this.playerStrategy = new PlayerStrategy(userInterface);
        this.enemyStrategy = new EnemyStrategy();
        this.roundResolver = new RoundResolver();
    }

    public RoundResult play() {
        userInterface.printRound(number);
        Move playerMove = Move.INVALID;
        while (playerMove == Move.INVALID) {
            playerMove = playerStrategy.getMove();
        }
        Move enemyMove = enemyStrategy.getMove();
        RoundResult roundResult = roundResolver.resolve(playerMove, enemyMove);
        userInterface.informRound(playerMove, enemyMove, roundResult);
        updateStatistics(roundResult);
        userInterface.informScore(statistics);
        return roundResult;
    }

    public RoundResult playAgainOrExit() {
        Move playerMove = Move.INVALID;
        while (playerMove == Move.INVALID) {
            playerMove = playerStrategy.getMove();
        }
        Move enemyMove = enemyStrategy.getMove();
        return roundResolver.resolve(playerMove, enemyMove);
    }

    private void updateStatistics(RoundResult result) {
        statistics.incrementRounds();
        if (result == RoundResult.WIN) statistics.incrementWins();
        if (result == RoundResult.LOSE) statistics.incrementLoses();
        if (result == RoundResult.DRAW) statistics.incrementDraws();
    }
}
