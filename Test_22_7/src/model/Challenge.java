package model;

public class Challenge {
    private String name;
    private int difficulty;
    private int treasureValue;

    public Challenge(String name, int difficulty, int treasureValue) {
        this.name = name;
        this.difficulty = difficulty;
        this.treasureValue = treasureValue;
    }

    public String getName() { return name; }
    public int getDifficulty() { return difficulty; }
    public int getTreasureValue() { return treasureValue; }
} 