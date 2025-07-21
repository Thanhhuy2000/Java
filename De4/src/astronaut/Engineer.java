package astronaut;

import mission.Mission;

public class Engineer extends Astronaut {
    private final int repairSkill; // Kỹ năng sửa chữa tàu (0-10)

    public Engineer(String name) {
        this.name = name;
        this.role = Role.ENGINEER;
        this.repairSkill = 5; // Giá trị mặc định cho kỹ năng sửa chữa
    }

    @Override
    public void performMission(Mission mission) {
        if (canPerform()) {
            mission.increaseDurability(repairSkill);
            System.out.println(name + " repaired the ship. Durability is now " + mission.getDurability());
        }
    }

    @Override
    public boolean canPerform() {
        return energy > 0;
    }

    @Override
    public void rest() {
        energy += 10; // Tăng 10 năng lượng mỗi lần nghỉ
        System.out.println(name + " is resting. Energy is now " + energy);
    }
}
