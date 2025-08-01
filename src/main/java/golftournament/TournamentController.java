package golftournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tournamnets")
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    // get all tournaments
    @GetMappingpublic List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    // Get tournaments through ID
    @GetMapping("/{id}")
    public tournament getTournamentById(@PathVariable int id){
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found"));
    }

    // Create a new tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Get all members in a tournament
    @GetMapping("/{id}/members")
    public List<Member> getTournamentMembers(@PathVariable int id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found"));
        return tournament.getMembers();
    }

    // Search tournaments by location
    @GetMapping("/searchByLocation")
    public List<Tournament> searchByLocation(@RequestParam String location) {
        return tournamentRepository.findByLocationContaining(location);
    }

    // Search tournaments by start date (yyyy-mm-dd)
    @GetMapping("/searchByStartDate")
    public List<Tournament> searchByStartDate(@RequestParam String date) {
        return tournamentRepository.findByStartDateString(date);
    }
}