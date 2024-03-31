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
    public String startGame() {
        return gameService.startGame();
    }

    @GetMapping("/game/{gameId}/guess/{number}")
    public String checkGuess(@PathVariable Long gameId, @PathVariable int number) {
        return gameService.checkGuess(gameId, number);
    }

}
