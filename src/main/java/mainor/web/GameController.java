// GameController.java
package mainor.web;

import mainor.dto.GameDto;
import mainor.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/game")
    public GameDto startGame() {
        String gameId = gameService.startGame();
        int targetNumber = gameService.getTargetNumber(gameId);
        return new GameDto(gameId, targetNumber);
    }

    @GetMapping("/game/{gameId}/guess/{number}")
    public String checkGuess(
            @PathVariable String gameId,
            @PathVariable int number) {
        return gameService.checkGuess(gameId, number);
    }

    @PostMapping("/game/{gameId}/restart") // Endpoint for restarting the game
    public String restartGame(@PathVariable String gameId) {
        if (gameService.restartGame(gameId)) {
            return "Game restarted";
        } else {
            return "Game ID not found";
        }
    }

}
