package units;

import players.Color;
import players.Player;

import java.util.Objects;

public class Ship implements Unit, Comparable<Ship> {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final ShipType ship;
    private Player ownedBy;


    public Ship(ShipType s, Player p) {
        this(s);
        ownedBy = p;
    }

    public Ship(ShipType s) {
        ship = s;
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

    public void setOwner(Player player) { //Constructor can't take outside input
        if (ownedBy == null)
            ownedBy = player;
        else
            throw new PlayerAlreadySetException();
    }

    public ShipType getShipType() {
        return ship;
    }

    public String toString() {
        if (ownedBy.getColor().equals(Color.Blue))
            return ANSI_BLUE + ship.toString() + ANSI_RESET;
        else if (ownedBy.getColor().equals(Color.Red))
            return ANSI_RED + ship.toString() + ANSI_RESET;
        else
            return ship.toString();
    }

    @Override
    public int compareTo(Ship o) {
        int combatCmp = o.getCombatValue() - getCombatValue();
        if (combatCmp != 0) //difference in combat value
            return combatCmp;
        else //they share combat value
            return o.getResCost() - getResCost(); //then more expensive must appear first
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship1 = (Ship) o;
        return Objects.equals(ownedBy, ship1.ownedBy) && ship == ship1.ship;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownedBy, ship);
    }
}

