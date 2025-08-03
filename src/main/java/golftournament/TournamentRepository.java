package golftournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    // Search by partial match on location
    List<Tournament> findByLocationContaining(String location);

    // Search by exact date (formatted as yyyy-MM-dd string)
    @Query("SELECT t FROM Tournament t WHERE FUNCTION('DATE_FORMAT', t.startDate, '%Y-%m-%d') = :date")
    List<Tournament> findByStartDateString(String date);
}
