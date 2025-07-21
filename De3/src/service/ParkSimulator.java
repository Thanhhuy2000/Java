package service;

import model.*;
import java.util.*;

public class ParkSimulator {
    private List<Team> teams;
    private int maxTurns;
    private int currentTurn;
    private List<String> logs;
    private Scanner scanner = new Scanner(System.in);

    public ParkSimulator(List<Team> teams, int maxTurns) {
        this.teams = teams;
        this.maxTurns = maxTurns;
        this.currentTurn = 0;
        this.logs = new ArrayList<>();
    }

    private boolean teamOutOfStamina(Team team) {
        for (Staff s : team.getMembers()) {
            if (s.getStamina() > 0) return false;
        }
        return true;
    }

    public void simulate() {
        for (currentTurn = 1; currentTurn <= maxTurns; currentTurn++) {
            for (Team team : teams) {
                if (teamOutOfStamina(team)) {
                    logs.add("Đội " + team.getName() + " đã hết stamina, kết thúc mô phỏng!");
                    printLogs();
                    return;
                }
                logs.add("=== Lượt " + currentTurn + ": Đội " + team.getName() + " ===");
                List<Staff> members = team.getMembers();
                System.out.println("Chọn nhân viên cho đội " + team.getName() + ":");
                for (int i = 0; i < members.size(); i++) {
                    Staff s = members.get(i);
                    System.out.printf("%d. %s (%s) - Stamina: %d, Đã xử lý: %d lượt\n", i+1, s.getName(), s.getRole(), s.getStamina(), s.getHandledTurns());
                }
                int idx = -1;
                while (true) {
                    System.out.print("Nhập số thứ tự nhân viên muốn chọn: ");
                    try {
                        idx = Integer.parseInt(scanner.nextLine()) - 1;
                        if (idx >= 0 && idx < members.size()) {
                            Staff chosen = members.get(idx);
                            if (chosen.getHandledTurns() < 2 && chosen.canWork()) {
                                Dinosaur dino = team.getDinosaurs().get(0);
                                chosen.handleDinosaur(new ParkState(), dino);
                                chosen.increaseHandledTurns();
                                logs.add(chosen.getName() + " (" + chosen.getRole() + ") chăm sóc " + dino.getName());
                                if (dino.isStable()) {
                                    team.increaseScore();
                                    logs.add("-> Khủng long ổn định!");
                                }
                                break;
                            } else if (chosen.getHandledTurns() >= 2) {
                                chosen.rest();
                                logs.add(chosen.getName() + " nghỉ ngơi.");
                                break;
                            } else {
                                System.out.println("Nhân viên không đủ stamina để làm việc!");
                            }
                        } else {
                            System.out.println("Chọn sai số thứ tự!");
                        }
                    } catch (Exception e) {
                        System.out.println("Nhập không hợp lệ!");
                    }
                }
            }
        }
    }

    public void printLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
} 