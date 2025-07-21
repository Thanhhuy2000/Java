package astronaut;

import mission.Mission;

public abstract class Astronaut {
    protected String name;
    protected int energy; // Năng lượng (0-100)
    protected Role role;

    // Enum để phân loại các vai trò của phi hành gia
    public enum Role {
        ENGINEER, PILOT, SCIENTIST
    }

    // Phương thức trừu tượng thực hiện nhiệm vụ
    public abstract void performMission(Mission mission);

    // Phương thức kiểm tra khả năng thực hiện nhiệm vụ
    public abstract boolean canPerform();

    // Phương thức cho phép phi hành gia nghỉ ngơi và phục hồi năng lượng
    public abstract void rest();

    // Chiến lược nghỉ ngơi linh hoạt
    public void rest(int hours) {
        // Chiến lược nghỉ ngơi cho mỗi phi hành gia dựa trên vai trò của họ
        switch (this.role) {
            case ENGINEER -> this.energy += hours * 2;  // Engineer hồi phục năng lượng nhanh hơn
            case PILOT -> this.energy += hours * 1;     // Pilot hồi phục năng lượng bình thường
            case SCIENTIST -> this.energy += hours * 3; // Scientist hồi phục năng lượng chậm hơn
        }
        if (this.energy > 100) this.energy = 100;  // Giới hạn năng lượng tối đa là 100
        System.out.println(name + " is resting for " + hours + " hours. Energy is now " + energy);
    }
}
