package golftournament;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Members")
public class Member {
    // Declare fields
    @Id // Mark primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    @Column(name = "Member_ID")
    private int id;

    @Column(name = "Member_Name")
    private String name;

    @Column(name = "Member_Address")
    private String address;

    @Column(name = "Member_Email")
    private String email;

    @Column(name = "Member_Phone_Number")
    private String phoneNumber;

    @Column(name = "Member_Start_Date")
    private Date startDate;

    @Column(name = "Member_Membership_Duration")
    private int membershipDuration;

    // Default constructor (required by JPA)
    public Member() {}

    // Constructor with fields
    public Member(String name, String address, String email, String phoneNumber, Date startDate, int membershipDuration) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.membershipDuration = membershipDuration;
    }

    // Getters then setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getMembershipDuration() {
        return membershipDuration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setMembershipDuration(int membershipDuration) {
        this.membershipDuration = membershipDuration;
    }
}
