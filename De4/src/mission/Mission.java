package mission;

public class Mission {
    private String name; // Tên nhiệm vụ
    private int durability; // Độ bền tàu
    private int timeRemaining; // Thời gian còn lại cho nhiệm vụ
    private int sciencePoints; // Điểm khoa học đạt được
    private int priority; // Mức độ ưu tiên của nhiệm vụ (1-10)

    // Constructor để khởi tạo nhiệm vụ
    public Mission(String name, int durability, int timeRemaining, int sciencePoints, int priority) {
        this.name = name;
        this.durability = durability;
        this.timeRemaining = timeRemaining;
        this.sciencePoints = sciencePoints;
        this.priority = priority;
    }

    // Kiểm tra xem nhiệm vụ đã hoàn thành hay chưa
    public boolean isCompleted() {
        return timeRemaining <= 0;
    }

    // Getters và setters
    public int getPriority() {
        return priority;
    }

    public void increaseDurability(int value) {
        this.durability += value;
    }

    public int getDurability() {
        return durability;
    }

    public void decreaseTimeRemaining(int value) {
        this.timeRemaining -= value;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }
}
