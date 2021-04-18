package units;

import players.Player;

public interface Unit {
    int getResCost();

    int getCombatValue();

    int getMoveSpeed();

    int getCapacity();

    Player getOwner();
}
