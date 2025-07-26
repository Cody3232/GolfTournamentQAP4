package golftournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members") // Base URL for members
public class MemberController {

    @Autowired
    private MemberRepository memberRepository; //injects MemberRepository into controller

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get a member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable int id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
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
        Member existingMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
        // Update other fields as needed
        return memberRepository.save(existingMember);
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable int id) {
        memberRepository.deleteById(id); // Just ID as it will always be unique
    }
}
