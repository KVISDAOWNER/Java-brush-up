import galaxy.DuplicatePlanetsException;
import galaxy.Galaxy;
import galaxy.IllegalCenterException;
import galaxy.MoreThan3PlanetsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import units.Ship;
import units.ShipType;
import units.Unit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GalaxyTest {
    Galaxy galaxy;
    @BeforeEach
    void beforeEach(){
        try {
            galaxy = new Galaxy();
        } catch (IllegalCenterException | MoreThan3PlanetsException | DuplicatePlanetsException e) {
            e.printStackTrace();
        }
    }
    @Test
    void getBlueShipsSorted() {
        var ships = galaxy.getShipsSorted(galaxy.getBluePlayer());
        List<Unit> expected = new ArrayList<>();
        expected.add(new Ship(ShipType.DESTROYER, galaxy.getBluePlayer()));
        expected.add(new Ship(ShipType.DREADNOUGHT, galaxy.getBluePlayer()));
        expected.add(new Ship(ShipType.DREADNOUGHT, galaxy.getBluePlayer()));

        assertArrayEquals(ships.toArray(), expected.toArray());
    }
}
