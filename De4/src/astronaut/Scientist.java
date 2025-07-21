package astronaut;

import mission.Mission;

public class Scientist extends Astronaut {
    private final int researchLevel; // Cấp độ nghiên cứu (0-10)

    public Scientist(String name) {
        this.name = name;
        this.role = Role.SCIENTIST;
        this.researchLevel = 7; // Giá trị mặc định cho cấp độ nghiên cứu
    }

    @Override
    public void performMission(Mission mission) {
        if (canPerform()) {
            mission.increaseSciencePoints(researchLevel);
            System.out.println(name + " gathered data. Science points: " + mission.getSciencePoints());
        }
    }

    @Override
    public boolean canPerform() {
        return energy > 0;
    }

    @Override
    public void rest() {
        energy += 10;
        System.out.println(name + " is resting. Energy is now " + energy);
    }
}
