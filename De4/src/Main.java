import astronaut.*;
import mission.Mission;
import team.Team;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo các phi hành gia
        Astronaut engineer = new Engineer("Minh");
        Astronaut pilot = new Pilot("Lan");
        Astronaut scientist = new Scientist("Hung");

        // Tạo các đội
        Team teamA = new Team(new Astronaut[]{engineer, pilot, scientist});
        Team teamB = new Team(new Astronaut[]{new Engineer("Nam"), new Pilot("Mai"), new Scientist("Khoa")});

        // Tạo nhiệm vụ
        Mission mission = new Mission("Repair Space Ship", 100, 50, 30, 8);

        // Thực hiện nhiệm vụ
        teamA.performMission(mission);
        System.out.println("Mission Completed: " + mission.isCompleted());
    }
}
