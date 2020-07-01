package com.kodilla.rps.engine;

import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.uix.UserInterface;

public class GameRunner {

    private final UserInterface userInterface;

    public GameRunner(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {

        boolean end = false;
        while (!end) {
            Game game = new Game(userInterface);
            GameResult result = game.start();
            if (result == GameResult.END) end = true;
        }
    }
}
