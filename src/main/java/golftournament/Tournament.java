package golftournament;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Tournament {
    // Declare Fields
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String location;

    @Column
    private double entryFee;

    @Column
    private double cashPrize; //Might remove from this table? Feels like it should be elsewhere

    // Many-to-many field
    @ManyToMany
    @JoinTable
    private List<Member> members;

    // Constructors (Default for JPA, and with parameters)
    public Tournament() {}

    public Tournament (Date startDate, Date endDate, String location, double entryFee, double cashPrize){
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
    }

    // Getters then setters
    public int getId(){
        return id;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
