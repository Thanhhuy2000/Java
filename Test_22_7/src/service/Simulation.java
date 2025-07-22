package service;

import model.*;
import exception.InvalidExplorerException;
import java.util.*;

public class Simulation {
    private ExpeditionState state;
    private List<Challenge> challenges;
    private Scanner scanner;

    public Simulation() {
        state = new ExpeditionState();
        challenges = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void setup() throws InvalidExplorerException {
        System.out.print("Nhập số đội: ");
        int numTeams = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < numTeams; t++) {
            System.out.print("Nhập tên đội " + (t+1) + ": ");
            String teamName = scanner.nextLine();
            Team team = new Team(teamName);
            for (int i = 0; i < 3; i++) {
                System.out.println("Nhập thông tin thành viên " + (i+1) + ":");
                System.out.print("Tên: ");
                String name = scanner.nextLine();
                System.out.print("Chọn vai trò (1: Hunter, 2: Guide, 3: Archaeologist): ");
                int roleNum = Integer.parseInt(scanner.nextLine());
                String roleName = "";
                Explorer explorer = null;
                int attr = 0;
                if (roleNum == 1) {
                    roleName = "Hunter";
                    System.out.print("Nhập chỉ số combatSkill (0-10): ");
                    attr = Integer.parseInt(scanner.nextLine());
                } else if (roleNum == 2) {
                    roleName = "Guide";
                    System.out.print("Nhập chỉ số navigationSkill (0-10): ");
                    attr = Integer.parseInt(scanner.nextLine());
                } else if (roleNum == 3) {
                    roleName = "Archaeologist";
                    System.out.print("Nhập chỉ số knowledge (0-10): ");
                    attr = Integer.parseInt(scanner.nextLine());
                } else {
                    throw new InvalidExplorerException("Vai trò không hợp lệ");
                }
                System.out.print("Nhập stamina (0-100): ");
                int stamina = Integer.parseInt(scanner.nextLine());
                if (roleNum == 1) {
                    explorer = new Hunter(i+1, name, stamina, attr);
                } else if (roleNum == 2) {
                    explorer = new Guide(i+1, name, stamina, attr);
                } else if (roleNum == 3) {
                    explorer = new Archaeologist(i+1, name, stamina, attr);
                }
                team.addExplorer(explorer);
            }
            state.addTeam(team);
        }
        // Tạo thử thách
        System.out.print("Nhập số thử thách: ");
        int numChallenges = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numChallenges; i++) {
            System.out.print("Tên thử thách " + (i+1) + ": ");
            String cname = scanner.nextLine();
            System.out.print("Độ khó: ");
            int diff = Integer.parseInt(scanner.nextLine());
            System.out.print("Giá trị kho báu: ");
            int value = Integer.parseInt(scanner.nextLine());
            challenges.add(new Challenge(cname, diff, value));
        }
    }

    public void run() {
        int turn = 0;
        boolean finished = false;
        while (turn < ExpeditionState.MAX_TURNS && !finished) {
            System.out.println("\n=== Lượt " + (turn+1) + " ===");
            for (Team team : state.getTeams()) {
                System.out.println("Đội: " + team.getName());
                List<Explorer> explorers = team.getExplorers();
                for (int i = 0; i < explorers.size(); i++) {
                    Explorer e = explorers.get(i);
                    System.out.println((i+1) + ". " + e.getName() + " (" + e.getRole() + ", Stamina: " + e.getStamina() + ")");
                }
                System.out.print("Chọn thành viên tham gia thử thách (1-3): ");
                int idx = Integer.parseInt(scanner.nextLine()) - 1;
                Explorer explorer = explorers.get(idx);
                if (!explorer.canExplore()) {
                    System.out.println("Thành viên này đã hết stamina!");
                    continue;
                }
                if (challenges.isEmpty()) {
                    System.out.println("Hết thử thách!");
                    finished = true;
                    break;
                }
                Challenge challenge = challenges.remove(0);
                boolean success = customChallengeFormula(explorer, challenge);
                if (success) {
                    team.addTreasure(challenge);
                    state.addLog(team.getName() + " - " + explorer.getName() + " vượt qua " + challenge.getName() + " (" + challenge.getTreasureValue() + ")");
                } else {
                    state.addLog(team.getName() + " - " + explorer.getName() + " thất bại ở " + challenge.getName());
                }
                explorer.decreaseStamina(20);
            }
            printResult(turn+1);
            // Kiểm tra nếu có đội nào hết stamina toàn bộ
            for (Team team : state.getTeams()) {
                boolean allOut = true;
                for (Explorer e : team.getExplorers()) {
                    if (e.getStamina() > 0) allOut = false;
                }
                if (allOut) finished = true;
            }
            turn++;
        }
        printRanking();
    }

    // Công thức vượt thử thách: (chỉ số chính * stamina) / độ khó > random(0,100)
    private boolean customChallengeFormula(Explorer explorer, Challenge challenge) {
        int mainStat = 0;
        if (explorer instanceof Guide) mainStat = ((Guide)explorer).getNavigationSkill();
        else if (explorer instanceof Archaeologist) mainStat = ((Archaeologist)explorer).getKnowledge();
        else if (explorer instanceof Hunter) mainStat = ((Hunter)explorer).getCombatSkill();
        double score = (mainStat * explorer.getStamina()) / (double)challenge.getDifficulty();
        double rand = Math.random() * 100;
        return score > rand;
    }

    public void printResult(int turn) {
        System.out.println("\n== Thành tích sau lượt " + turn + " ==");
        for (Team team : state.getTeams()) {
            System.out.println(team.getName() + ": " + team.getScore() + " điểm, " + team.getTreasures().size() + " thử thách vượt qua");
        }
    }

    public void printRanking() {
        List<Team> teams = new ArrayList<>(state.getTeams());
        teams.sort((a, b) -> b.getScore() - a.getScore());
        System.out.println("\n== Xếp hạng theo điểm kho báu ==");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i+1) + ". " + teams.get(i).getName() + ": " + teams.get(i).getScore() + " điểm");
        }
    }
} 