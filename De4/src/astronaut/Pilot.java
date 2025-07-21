package astronaut;

import mission.Mission;

public class Pilot extends Astronaut {
    private final int navigationSkill; // Kỹ năng điều hướng (0-10)

    public Pilot(String name) {
        this.name = name;
        this.role = Role.PILOT;
        this.navigationSkill = 6; // Giá trị mặc định cho kỹ năng điều hướng
    }

    @Override
    public void performMission(Mission mission) {
        if (canPerform()) {
            mission.decreaseTimeRemaining(navigationSkill);
            System.out.println(name + " piloted the ship. Time remaining: " + mission.getTimeRemaining());
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
