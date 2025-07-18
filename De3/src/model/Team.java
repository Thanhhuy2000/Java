package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Staff> members;
    private List<Dinosaur> dinosaurs;
    private int score;

    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.dinosaurs = new ArrayList<>();
        this.score = 0;
    }

    public void addMember(Staff staff) {
        if (members.size() < 3) {
            members.add(staff);
        }
    }

    public void addDinosaur(Dinosaur dino) {
        dinosaurs.add(dino);
    }

    public List<Staff> getMembers() { return members; }
    public List<Dinosaur> getDinosaurs() { return dinosaurs; }
    public int getScore() { return score; }
    public void increaseScore() { score++; }
    public String getName() { return name; }
} 