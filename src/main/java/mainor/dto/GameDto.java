// GameDto.java
package mainor.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GameDto {
    @Id
    @GeneratedValue
    private Long gameId;
    private int targetNumber;
    private int tryCount = 0;
    private boolean completed = false;
}
