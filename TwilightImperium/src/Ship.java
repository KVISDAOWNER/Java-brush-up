public enum Ship implements Unit {
    Destroyer(1,9,2,0),
    Cruiser(2,7,2,0),
    Carrier(3,9,1,6),
    Dreadnought(5,5,1,0);

    private int res_cost;
    private int combat_value;
    private int move_speed;
    private int capacity;

    Ship(int res_cost, int combat_value, int move_speed, int capacity){
        this.res_cost = res_cost;
        this.combat_value = combat_value;
        this.move_speed = move_speed;
        this.capacity = capacity;
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
