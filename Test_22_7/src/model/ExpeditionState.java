package model;

import java.util.ArrayList;
import java.util.List;

public class ExpeditionState {
    private List<Team> teams;
    private int currentTurn;
    private List<String> log;
    public static final int MAX_TURNS = 8;

    public ExpeditionState() {
        teams = new ArrayList<>();
        log = new ArrayList<>();
        currentTurn = 0;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void nextTurn() {
        currentTurn++;
    }

    public List<String> getLog() {
        return log;
    }

    public void addLog(String entry) {
        log.add(entry);
    }
} 