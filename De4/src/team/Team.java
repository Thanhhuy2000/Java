package team;

import astronaut.Astronaut;
import mission.Mission;

public class Team {
    private Astronaut[] astronauts; // Danh sách các phi hành gia trong đội

    // Constructor để khởi tạo đội phi hành gia
    public Team(Astronaut[] astronauts) {
        this.astronauts = astronauts;
    }

    // Phương thức để thực hiện nhiệm vụ
    public void performMission(Mission mission) {
        // Lọc ra phi hành gia có thể thực hiện nhiệm vụ và có mức độ ưu tiên cao nhất
        Astronaut bestAstronaut = null;
        int highestPriority = 0;

        for (Astronaut astronaut : astronauts) {
            if (astronaut.canPerform() && mission.getPriority() > highestPriority) {
                bestAstronaut = astronaut;
                highestPriority = mission.getPriority();
            }
        }

        if (bestAstronaut != null) {
            bestAstronaut.performMission(mission);
            System.out.println(bestAstronaut.getName() + " performed the mission: " + mission.getName());
        } else {
            System.out.println("No astronaut can perform the mission right now.");
        }
    }

    // Phương thức lấy tổng điểm khoa học từ đội
    public int getTotalSciencePoints() {
        int total = 0;
        for (Astronaut astronaut : astronauts) {
            if (astronaut instanceof Scientist) {
                total += ((Scientist) astronaut).researchLevel;
            }
        }
        return total;
    }
}
