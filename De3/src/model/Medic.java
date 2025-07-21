package model;

public class Medic extends Staff {
    private int healRate; // 0-10

    public Medic(String id, String name, int stamina, int healRate) {
        super(id, name, stamina, Role.MEDIC);
        this.healRate = healRate;
    }

    @Override
    public void handleDinosaur(ParkState state, Dinosaur dinosaur) {
        // Chữa trị khủng long bị thương theo công thức mới
        int newHealth = dinosaur.getHealth() + healRate * 10;
        dinosaur.setHealth(Math.min(100, newHealth));
        this.decreaseStamina(18);
    }

    @Override
    public boolean canWork() {
        return stamina >= 18;
    }

    public int getHealRate() { return healRate; }
} 