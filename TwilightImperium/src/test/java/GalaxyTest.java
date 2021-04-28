import galaxy.DuplicatePlanetsException;
import galaxy.Galaxy;
import galaxy.IllegalCenterException;
import galaxy.MoreThan3PlanetsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planets.Planet;
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
    void getRedShipsSorted() {
        var ships = galaxy.getShipsSorted(galaxy.getRedPlayer());
        List<Unit> expected = new ArrayList<>();
        expected.add(new Ship(ShipType.CARRIER, galaxy.getRedPlayer()));
        expected.add(new Ship(ShipType.CRUISER, galaxy.getRedPlayer()));
        expected.add(new Ship(ShipType.CRUISER, galaxy.getRedPlayer()));

        assertArrayEquals(ships.toArray(), expected.toArray());
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

    @Test
    void getRedPlanets() {
        var planets = galaxy.getPlanets(galaxy.getRedPlayer());
        List<Planet> expected = new ArrayList<>();
        expected.add(Planet.VEGAMINOR);
        expected.add(Planet.VEGAMAJOR);

        assertArrayEquals(planets.toArray(), expected.toArray());
    }

    @Test
    void getBluePlanets() {
        var planets = galaxy.getPlanets(galaxy.getBluePlayer());
        List<Planet> expected = new ArrayList<>();
        expected.add(Planet.MECATOLREX);

        assertArrayEquals(planets.toArray(), expected.toArray());

    }
}
