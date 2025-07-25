package golftournament;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Make tournament object
        Tournament myTournament = new Tournament(new Date(), new Date(), "CBS", 100, 5000);

        // Display info in terminal for now
        System.out.println("Tournament Location: " + myTournament.getLocation());
        System.out.println("Tournament Entry Fee: " + myTournament.getEntryFee());
    }
}