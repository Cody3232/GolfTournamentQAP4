package golftournament;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    // Search members by name (partial match)
    List<Member> findByNameContaining(String name);

    // Search members by phone number
    List<Member> findByPhoneNumber(String phoneNumber);

    // Search members by e-mail
    List<Member> findByEmail(String email);

}
