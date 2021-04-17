public enum Ship implements Unit {
    DESTROYER(1, 9, 2, 0),
    CRUISER(2, 7, 2, 0),
    CARRIER(3, 9, 1, 6),
    DREADNOUGHT(5, 5, 1, 0);

    private int res_cost;
    private int combat_value;
    private int move_speed;
    private int capacity;
    private Player ownedBy;

    Ship(int res_cost, int combat_value, int move_speed, int capacity) {
        this.res_cost = res_cost;
        this.combat_value = combat_value;
        this.move_speed = move_speed;
        this.capacity = capacity;
    }

    public void setOwner(Player player) { //Constructor can't take outside input
        if (ownedBy != null)
            ownedBy = player;
        else
            throw new PlayerAlreadySetException();
    }


    @Override
    public int getResCost() {
        return res_cost;
    }

    @Override
    public int getCombatValue() {
        return combat_value;
    }

    @Override
    public int getMoveSpeed() {
        return move_speed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}

class PlayerAlreadySetException extends IllegalArgumentException {
    PlayerAlreadySetException() {
        super("Player all ready set");
    }
}