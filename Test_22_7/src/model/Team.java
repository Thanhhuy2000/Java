package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Explorer> explorers;
    private List<Challenge> treasures;
    private int score;

    public Team(String name) {
        this.name = name;
        this.explorers = new ArrayList<>();
        this.treasures = new ArrayList<>();
        this.score = 0;
    }

    public void addExplorer(Explorer explorer) {
        explorers.add(explorer);
    }

    public List<Explorer> getExplorers() {
        return explorers;
    }

    public void addTreasure(Challenge challenge) {
        treasures.add(challenge);
        score += challenge.getTreasureValue();
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public List<Challenge> getTreasures() {
        return treasures;
    }
} 