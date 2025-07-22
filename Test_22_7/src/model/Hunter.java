package model;

public class Hunter extends Explorer {
    private int combatSkill; // 0-10

    public Hunter(int id, String name, int stamina, int combatSkill) throws exception.InvalidExplorerException {
        super(id, name, stamina, Role.HUNTER);
        if (combatSkill < 0 || combatSkill > 10) throw new exception.InvalidExplorerException("combatSkill must be 0-10");
        this.combatSkill = combatSkill;
    }

    public int getCombatSkill() { return combatSkill; }

    @Override
    public boolean overcomeChallenge(ExpeditionState state, Challenge challenge) {
        // Giảm nguy cơ từ thử thách
        double success = (double) combatSkill / challenge.getDifficulty();
        if (Math.random() < success) {
            decreaseStamina(20);
            return true;
        } else {
            decreaseStamina(20);
            return false;
        }
    }
} 