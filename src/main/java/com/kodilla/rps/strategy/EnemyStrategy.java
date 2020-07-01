package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;

import java.util.Random;

public class EnemyStrategy implements Strategy {

    private static final Random random = new Random();

    @Override
    public Move getMove() {
        int key = random.nextInt(3) + 1;
        if (key == 1) return Move.get(0);
        if (key == 2) return Move.get(1);
        return Move.get(2);
    }
}
