package model;

public class Archaeologist extends Explorer {
    private int knowledge; // 0-10

    public Archaeologist(int id, String name, int stamina, int knowledge) throws exception.InvalidExplorerException {
        super(id, name, stamina, Role.ARCHAEOLOGIST);
        if (knowledge < 0 || knowledge > 10) throw new exception.InvalidExplorerException("knowledge must be 0-10");
        this.knowledge = knowledge;
    }

    public int getKnowledge() { return knowledge; }

    @Override
    public boolean overcomeChallenge(ExpeditionState state, Challenge challenge) {
        // Tăng giá trị kho báu nếu vượt qua
        double success = (double) knowledge / challenge.getDifficulty();
        if (Math.random() < success) {
            decreaseStamina(20);
            return true;
        } else {
            decreaseStamina(20);
            return false;
        }
    }
} 