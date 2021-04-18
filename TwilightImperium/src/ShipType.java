public enum ShipType {
    DESTROYER(1, 9, 2, 0),
    CRUISER(2, 7, 2, 0),
    CARRIER(3, 9, 1, 6),
    DREADNOUGHT(5, 5, 1, 0);

    public final int res_cost;
    public final int combat_value;
    public final int move_speed;
    public final int capacity;

    ShipType(int res_cost, int combat_value, int move_speed, int capacity) {
        this.res_cost = res_cost;
        this.combat_value = combat_value;
        this.move_speed = move_speed;
        this.capacity = capacity;
    }

}
