package model;

public class Ranger extends Staff {
    private int controlSkill; // 0-10

    public Ranger(String id, String name, int stamina, int controlSkill) {
        super(id, name, stamina, Role.RANGER);
        this.controlSkill = controlSkill;
    }

    @Override
    public void handleDinosaur(ParkState state, Dinosaur dinosaur) {
        // Giảm nguy cơ sự cố theo công thức mới
        int newDanger = dinosaur.getDangerLevel() - controlSkill;
        dinosaur.setDangerLevel(Math.max(0, newDanger));
        this.decreaseStamina(15);
    }

    @Override
    public boolean canWork() {
        return stamina >= 15;
    }

    public int getControlSkill() { return controlSkill; }
} 