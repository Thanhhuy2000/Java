package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<Player> players;
    private int score;

    public Team(int id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<Player>();
        this.score = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public int getActivePlayers() {
        int num = 0;
        for (Player player : players) {
            if(player.canAct()) {
                num++;
            }
        }
        return num;
    }
    public void inforTeam() {
        System.out.println("Thanh vien cua doi " + this.name);
        for (Player player : this.players) {
            System.out.println("  + ID: " + player.getId() + " Name: " + player.getName() + " (" + player.getRole() + ")" + ": Stamina: " + player.getStamina());
        }
    }
    public void displayStatus() {
        System.out.println("Trang thai:");
        System.out.println(" * Doi " + this.name + ": Score: " + this.score);
        for (Player player : this.players) {
            System.out.println("  + " + player.getName() + " (" + player.getRole() + ")" + ": Stamina: " + player.getStamina());
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Player> getPlayers() { return players; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
