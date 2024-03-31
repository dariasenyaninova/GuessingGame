package mainor.repository;

import mainor.dto.GameDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<GameDto, Long> {
}
