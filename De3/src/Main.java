import java.util.*;
import model.*;
import service.ParkSimulator;

public class Main {
    public static void main(String[] args) {
        // Tạo đội A
        Team teamA = new Team("A");
        teamA.addMember(new Scientist("A1", "Minh", 80, 8));
        teamA.addMember(new Ranger("A2", "Lan", 100, 7));
        teamA.addMember(new Medic("A3", "Hùng", 100, 6));
        teamA.addDinosaur(new Dinosaur("T-Rex", 60, 7));

        // Tạo đội B
        Team teamB = new Team("B");
        teamB.addMember(new Scientist("B1", "Nam", 100, 7));
        teamB.addMember(new Ranger("B2", "Mai", 100, 8));
        teamB.addMember(new Medic("B3", "Khoa", 100, 7));
        teamB.addDinosaur(new Dinosaur("Triceratops", 55, 6));

        List<Team> teams = Arrays.asList(teamA, teamB);
        ParkSimulator simulator = new ParkSimulator(teams, 2);
        simulator.simulate();
        simulator.printLogs();
    }
}