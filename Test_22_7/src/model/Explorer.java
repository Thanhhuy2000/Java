package model;

import exception.InvalidExplorerException;

public abstract class Explorer {
    protected int id;
    protected String name;
    protected int stamina;
    protected Role role;

    public Explorer(int id, String name, int stamina, Role role) throws InvalidExplorerException {
        if (stamina < 0 || stamina > 100) throw new InvalidExplorerException("Stamina must be 0-100");
        this.id = id;
        this.name = name;
        this.stamina = stamina;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getStamina() { return stamina; }
    public Role getRole() { return role; }
    public void rest() { stamina = Math.min(100, stamina + 20); }
    public boolean canExplore() { return stamina > 0; }
    public void decreaseStamina(int amount) { stamina = Math.max(0, stamina - amount); }

    public abstract boolean overcomeChallenge(ExpeditionState state, Challenge challenge);
} 