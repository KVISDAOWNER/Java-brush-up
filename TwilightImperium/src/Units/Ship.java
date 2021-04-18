package Units;

import Players.Color;
import Players.Player;

public class Ship implements Unit, Comparable<Ship> {

    private Player ownedBy;

    private ShipType ship;

    public Ship(ShipType s) {
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

    @Override
    public Player getOwner() {
        return ownedBy;
    }

    public String toString() {
        if (ownedBy.getColor().equals(Color.Blue))
            return ANSI_BLUE + ship.toString() + ANSI_RESET;
        else if (ownedBy.getColor().equals(Color.Red))
            return ANSI_RED + ship.toString() + ANSI_RESET;
        else
            return ship.toString();
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    @Override
    public int compareTo(Ship o) {
        int combatCmp = o.getCombatValue() - getCombatValue();
        if (combatCmp != 0) //difference in combat value
            return combatCmp;
        else //they share combat value
            return o.getResCost() - getResCost(); //then more expensive must appear first
    }
}

