// GameService.java
package mainor.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GameService {
    private final Map<String, Integer> gameMap = new HashMap<>();
    private final Map<String, Integer> guessCountMap = new HashMap<>();

    public String startGame() {
        String gameId = generateGameId();
        int targetNumber = generateRandomNumber();
        gameMap.put(gameId, targetNumber);
        guessCountMap.put(gameId, 0);
        return gameId;
    }

    public String checkGuess(String gameId, int number) {
        if (!gameMap.containsKey(gameId)) {
            return "Game ID not found";
        }

        int targetNumber = gameMap.get(gameId);
        int guessCount = guessCountMap.get(gameId);

        guessCount++;
        guessCountMap.put(gameId, guessCount);

        if (number > targetNumber) {
            return "Nr is smaller";
        } else if (number < targetNumber) {
            return "Nr is bigger";
        } else {
            return "Correct, it took you " + guessCount + " times";
        }
    }

    public int getTargetNumber(String gameId) {
        return gameMap.getOrDefault(gameId, -1);
    }

    public boolean restartGame(String gameId) {
        if (gameMap.containsKey(gameId)) {
            gameMap.remove(gameId);
            return true;
        } else {
            return false;
        }
    }

    private String generateGameId() {
        Random random = new Random();
        return "game_" +  random.nextInt(1000000);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

}
