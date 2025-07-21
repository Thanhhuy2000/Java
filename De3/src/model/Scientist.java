package model;

public class Scientist extends Staff {
    private int researchSkill; // 0-10

    public Scientist(String id, String name, int stamina, int researchSkill) {
        super(id, name, stamina, Role.SCIENTIST);
        this.researchSkill = researchSkill;
    }

    @Override
    public void handleDinosaur(ParkState state, Dinosaur dinosaur) {
        // Tăng sức khỏe khủng long theo công thức mới
        int newHealth = dinosaur.getHealth() + researchSkill * 8;
        dinosaur.setHealth(Math.min(100, newHealth));
        this.decreaseStamina(20);
    }

    @Override
    public boolean canWork() {
        return stamina >= 20;
    }

    public int getResearchSkill() { return researchSkill; }
} 