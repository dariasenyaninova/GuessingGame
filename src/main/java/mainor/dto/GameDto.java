// GameDto.java
package mainor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameDto {
    private String gameId;
    private int targetNumber;
}
