import galaxy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planets.Planet;
import players.Race;
import units.Ship;
import units.ShipType;
import units.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void defaultGalaxyOk() {
        var planets = galaxy.getPlanets();
        List<Planet> expectedPlanets = new ArrayList<>();
        expectedPlanets.add(Planet.MECATOLREX);
        expectedPlanets.add(Planet.VEGAMINOR);
        expectedPlanets.add(Planet.VEGAMAJOR);
        expectedPlanets.add(Planet.INDUSTREX);
        expectedPlanets.add(Planet.RIGEL1);
        expectedPlanets.add(Planet.RIGEL2);
        expectedPlanets.add(Planet.MIRAGE);

        var blue = galaxy.getBluePlayer();
        var red = galaxy.getRedPlayer();

        List<Unit> centerUnits = galaxy.getSystem(Position.CENTER).getUnits();
        List<ShipType> expectedCenterUnitTypes = new ArrayList<>();
        expectedCenterUnitTypes.add(ShipType.DREADNOUGHT);
        expectedCenterUnitTypes.add(ShipType.DREADNOUGHT);
        expectedCenterUnitTypes.add(ShipType.DESTROYER);

        List<Unit> northUnits = galaxy.getSystem(Position.NORTH).getUnits();
        List<ShipType> expectedNorthUnitTypes = new ArrayList<>();
        expectedNorthUnitTypes.add(ShipType.CRUISER);
        expectedNorthUnitTypes.add(ShipType.CRUISER);
        expectedNorthUnitTypes.add(ShipType.CARRIER);

        //Ok planets?
        assertArrayEquals(planets.toArray(), expectedPlanets.toArray());

        //Ok players?
        assertEquals(blue.getRace(), Race.THE_EMIRATES_OF_HACAN);
        assertEquals(red.getRace(), Race.THE_FEDERATION_OF_SOL);
        assertEquals(blue.getName(), "Crassus");
        assertEquals(red.getName(), "Pompey");

        //Ok ships in center?
        assertArrayEquals(
                centerUnits.stream().map(unit -> ((Ship)unit).getShipType()).collect(Collectors.toList()).toArray(),
                expectedCenterUnitTypes.toArray());

        //Ok ships in north?
        assertArrayEquals(
                northUnits.stream().map(unit -> ((Ship)unit).getShipType()).collect(Collectors.toList()).toArray(),
                expectedNorthUnitTypes.toArray());

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
