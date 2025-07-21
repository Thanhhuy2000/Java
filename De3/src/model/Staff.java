package model;

public abstract class Staff {
    protected String id;
    protected String name;
    protected int stamina; // 0-100
    protected Role role;
    protected int handledTurns = 0;

    public Staff(String id, String name, int stamina, Role role) {
        this.id = id;
        this.name = name;
        this.stamina = stamina;
        this.role = role;
    }

    public abstract void handleDinosaur(ParkState state, Dinosaur dinosaur);
    public abstract boolean canWork();
    public void rest() {
        this.stamina = Math.min(100, this.stamina + 20);
    }

    public String getName() { return name; }
    public int getStamina() { return stamina; }
    public Role getRole() { return role; }
    public void decreaseStamina(int amount) {
        this.stamina = Math.max(0, this.stamina - amount);
    }

    public void increaseHandledTurns() { handledTurns++; }
    public int getHandledTurns() { return handledTurns; }
} 