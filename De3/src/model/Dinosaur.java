package model;

public class Dinosaur {
    private String name;
    private int health;
    private int dangerLevel;

    public Dinosaur(String name, int health, int dangerLevel) {
        this.name = name;
        this.health = health;
        this.dangerLevel = dangerLevel;
    }

    public boolean isStable() {
        return health > 50 && dangerLevel < 5;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDangerLevel() { return dangerLevel; }
    public void setHealth(int health) { this.health = health; }
    public void setDangerLevel(int dangerLevel) { this.dangerLevel = dangerLevel; }
} 