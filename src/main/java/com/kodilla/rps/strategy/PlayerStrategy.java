package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.uix.UserInterface;

public class PlayerStrategy implements Strategy {

    private final UserInterface userInterface;

    public PlayerStrategy(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public Move getMove() {

        String move = userInterface.getMove();
        if (move.equals("1")) return Move.get(0);
        if (move.equals("2")) return Move.get(1);
        if (move.equals("3")) return Move.get(2);
        if (move.equals("x")) return Move.get(3);
        if (move.equals("n")) return Move.get(4);
        return Move.get(5);

    }
}
