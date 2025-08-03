package golftournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    // Search members by name (partial match)
    List<Member> findByNameContaining(String name);

    // Search members by phone number
    List<Member> findByPhoneNumber(String phoneNumber);

    // Search members by e-mail
    List<Member> findByEmail(String email);

    @Query("SELECT m FROM Member m WHERE FUNCTION('DATE_FORMAT', m.startDate, '%Y-%m-%d') = :date")
    List<Member> findByStartDateString(String date);

}
