// GameService.java
package mainor.service;

import lombok.AllArgsConstructor;
import mainor.dto.GameDto;
import mainor.repository.GameRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepo repository;


    public String startGame() {
        int targetNumber = generateRandomNumber();
        GameDto gameDto =  new GameDto();
        gameDto.setTargetNumber(targetNumber);

        GameDto saved = repository.save(gameDto);
        return saved.getGameId().toString();
    }

    public String checkGuess(Long gameId, int number) {
        Optional<GameDto> optionalGame = repository.findById(gameId);

        if (optionalGame.isEmpty()){
            return "GameId not found";
        }

        GameDto gameDto = optionalGame.get();
        int targetNumber = gameDto.getTargetNumber();
        int guessCount = gameDto.getTryCount();

        if(gameDto.isCompleted()){
            return "Game is already completed. It took you " + guessCount + " times. ";
        }

        guessCount++;

        gameDto.setTryCount(guessCount);
        repository.save(gameDto);

        if (number > targetNumber) {
            return "Nr is smaller";
        } else if (number < targetNumber) {
            return "Nr is bigger";
        } else {
            gameDto.setCompleted(true);
            repository.save(gameDto);

            return "Correct, it took you " + guessCount + " times";
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

}
