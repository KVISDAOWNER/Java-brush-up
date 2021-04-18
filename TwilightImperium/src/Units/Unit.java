package Units;

import Players.Player;

public interface Unit {
    int getResCost();

    int getCombatValue();

    int getMoveSpeed();

    int getCapacity();

    Player getOwner();
}
