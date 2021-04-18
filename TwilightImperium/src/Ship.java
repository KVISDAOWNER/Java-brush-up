public class Ship implements Unit {

    private Player ownedBy;

    private ShipType ship;

    Ship(ShipType s){
        ship = s;
    }
    public void setOwner(Player player) { //Constructor can't take outside input
        if (ownedBy == null)
            ownedBy = player;
        else
            throw new PlayerAlreadySetException();
    }


    @Override
    public int getResCost() {
        return ship.res_cost;
    }

    @Override
    public int getCombatValue() {
        return ship.combat_value;
    }

    @Override
    public int getMoveSpeed() {
        return ship.move_speed;
    }

    @Override
    public int getCapacity() {
        return ship.capacity;
    }
}

class PlayerAlreadySetException extends IllegalArgumentException {
    PlayerAlreadySetException() {
        super("Player all ready set");
    }
}