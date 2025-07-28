package model;

public class Guide extends Explorer {
    private int navigationSkill; // 0-10

    public Guide(int id, String name, int stamina, int navigationSkill) throws exception.InvalidExplorerException {
        super(id, name, stamina, Role.GUIDE);
        if (navigationSkill < 0 || navigationSkill > 10) throw new exception.InvalidExplorerException("navigationSkill must be 0-10");
        this.navigationSkill = navigationSkill;
    }

    public int getNavigationSkill() { return navigationSkill; }

    @Override
    public boolean overcomeChallenge(ExpeditionState state, Challenge challenge) {
        // Tăng xác suất vượt thử thách
        double success = (double) navigationSkill / challenge.getDifficulty();
        if (Math.random() < success) {
            decreaseStamina(20);
            return true;
        } else {
            decreaseStamina(20);
            return false;
        }
    }
} 