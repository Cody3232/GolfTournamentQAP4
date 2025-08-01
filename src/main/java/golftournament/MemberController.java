package golftournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/members") // Base URL for members
public class MemberController {

    @Autowired
    private MemberRepository memberRepository; // Injects MemberRepository into controller

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get a member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable int id) {
        // Improved error handling: return 404 if member not found
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
    }

    // Search members by name (partial match)
    @GetMapping("/searchByName")
    public List<Member> searchMembersByName(@RequestParam String name) {
        return memberRepository.findByNameContaining(name);
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

        // Update existing member's details
        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
        // Add other fields if needed
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
}
