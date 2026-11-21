package com.comp2042;

import java.io.*;
/**
 * Manages the reading and writing of the high score to a local text file.
 * This ensures the player's highest score persists between game sessions.
 */
public class ScoreManager {
    private static final String FILE_NAME = "highscore.txt";

    public static int getHighScore() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return 0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading high score: " + e.getMessage());
        }
        return 0;
    }

    public static void saveHighScore(int score) {
        int currentHighScore = getHighScore();
        if (score > currentHighScore) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(String.valueOf(score));
            } catch (IOException e) {
                System.out.println("Error saving high score: " + e.getMessage());
            }
        }
    }
}
