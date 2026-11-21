package com.comp2042;

import java.util.Random;
/**
 * A Factory class responsible for creating different types of Coin objects.
 * This decouples the coin generation logic from the GameController.
 */
public class CoinFactory {

    private static final Random random = new Random();

    public static Coin createCoin(Game game, Snake snek, Obstacle obstacle) {
        // Cast width and height to int to match the Coin constructor
        int width = (int) game.getWidth();
        int height = (int) game.getHeight();

        if (!game.isPowerUp()) {
            return new Coin(width, height, snek, obstacle);
        }

        int ran = random.nextInt(12);

        switch (ran) {
            case 1:
                return new GoldCoin(width, height, snek, obstacle);
            case 2:
                return new RainbowCoin(width, height, snek, obstacle);
            case 3:
                return new BlueCoin(width, height, snek, obstacle);
            case 4:
                // Reverted to .size() == 0 because your Obstacle class might not use java.util.List
                if (obstacle.getObstacles().size() == 0) {
                    return new SilverCoin(width, height, snek, obstacle);
                }
                return new Coin(width, height, snek, obstacle);
            default:
                return new Coin(width, height, snek, obstacle);
        }
    }
}