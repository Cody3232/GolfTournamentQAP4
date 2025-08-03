package golftournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Add a new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    // Update a member
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member updatedMember) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
        return memberRepository.save(existingMember);
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable int id) {
        memberRepository.findById(id).ifPresentOrElse(
                member -> memberRepository.delete(member),
                () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"); }
        );
    }

    // Search members by name
    @GetMapping("/searchByName")
    public List<Member> searchMembersByName(@RequestParam String name) {
        return memberRepository.findByNameContaining(name);
    }

    // Search members by phone number
    @GetMapping("/searchByPhoneNumber")
    public List<Member> searchByPhoneNumber(@RequestParam String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    // Search members by email
    @GetMapping("/searchByEmail")
    public List<Member> searchByEmail(@RequestParam String email) {
        return memberRepository.findByEmail(email);
    }

    // Search members by start date
    @GetMapping("/searchByStartDate")
    public List<Member> searchByStartDate(@RequestParam String date) {
        return memberRepository.findByStartDateString(date);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable int id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
    }
}
