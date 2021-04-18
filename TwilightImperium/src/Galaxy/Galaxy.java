package Galaxy;

import Planets.Planet;
import Players.Color;
import Players.Player;
import Players.Race;
import Units.Ship;
import Units.ShipType;
import Units.Unit;
import Systems.System;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class Galaxy {
    //Overvej andet end list - måske en form for set (så der ikke kan være duplicates?
    List<System> systems = new ArrayList<>();

    private Player blue;
    private Player red;

    public Galaxy() throws IllegalCenterException, MoreThan3PlanetsException, DuplicatePlanetsException { //Default map setup
        blue = new Player("Crassus", Race.THE_EMIRATES_OF_HACAN, Color.Blue);
        red = new Player("Pompey", Race.THE_FEDERATION_OF_SOL, Color.Red);

        spawnDefaultSystems();
        spawnDefaultShips(blue, red);
        isLegal();
    }

    public Player getBluePlayer() {
        return blue;
    }

    public Player getRedPlayer() {
        return red;
    }

    private void spawnDefaultSystems() {
        List<Planet> centerPlanets = new ArrayList<>();
        centerPlanets.add(Planet.MECATOLREX);
        systems.add(new System(centerPlanets, Position.CENTER));

        List<Planet> northPlanets = new ArrayList<>();
        northPlanets.add(Planet.VEGAMINOR);
        northPlanets.add(Planet.VEGAMAJOR);
        systems.add(new System(northPlanets, Position.NORTH));

        List<Planet> northEastPlanets = new ArrayList<>();
        systems.add(new System(northEastPlanets, Position.NORTH_EAST)); //empty system

        List<Planet> southEastPlanets = new ArrayList<>();
        southEastPlanets.add(Planet.INDUSTREX);
        systems.add(new System(southEastPlanets, Position.SOUTH_EAST));

        List<Planet> southPlanets = new ArrayList<>();
        southPlanets.add(Planet.RIGEL1);
        southPlanets.add(Planet.RIGEL2);
        systems.add(new System(southPlanets, Position.SOUTH));

        List<Planet> southWestPlanets = new ArrayList<>();
        systems.add(new System(southWestPlanets, Position.SOUTH_WEST));

        List<Planet> northWestPlanets = new ArrayList<>();
        northWestPlanets.add(Planet.MIRAGE);
        systems.add(new System(northWestPlanets, Position.NORTH_WEST));
    }

    private void spawnDefaultShips(Player blue, Player red) {
        var center = getSystem(Position.CENTER);
        center.enter(spawnShip("DREADNOUGHT", blue));
        center.enter(spawnShip("DREADNOUGHT", blue));
        center.enter(spawnShip("DESTROYER", blue));

        var north = getSystem(Position.NORTH);
        north.enter(spawnShip("CRUISER", red));
        north.enter(spawnShip("CRUISER", red));
        north.enter(spawnShip("CARRIER", red));
    }

    private System getSystem(Position p) {
        return systems.stream()
                .filter(s -> s.getPosition().equals(p))  //filter returns a lazy (intermediate representation) stream so not inefficient - recall from functional programming?
                .findFirst()
                .orElseThrow(); //throw if no match
    }


    private Ship spawnShip(String shipName, Player p) {
        Ship s;

        switch (shipName) {
            case "DREADNOUGHT":
                s = new Ship(ShipType.DREADNOUGHT);
                break;
            case "DESTROYER":
                s = new Ship(ShipType.DESTROYER);
                break;
            case "CRUISER":
                s = new Ship(ShipType.CRUISER);
                break;
            case "CARRIER":
                s = new Ship(ShipType.CARRIER);
                break;
            default:
                throw new IllegalArgumentException("Unexpected shipName: " + shipName);
        }
        s.setOwner(p);

        return s;
    }

    private boolean isLegal() throws IllegalCenterException, MoreThan3PlanetsException, DuplicatePlanetsException {
        //The center system must have exactly one planet named Mecatol Rex
        var centerPlanets = getSystem(Position.CENTER)
                .getPlanets();
        var mecatolrex = centerPlanets
                .stream()
                .filter(p -> p.equals(Planet.MECATOLREX))
                .findFirst()
                .orElse(null);
        if (mecatolrex == null || centerPlanets.size() > 1)
            throw new IllegalCenterException();


        //Every planet belongs to at most one system.
        var planets = getPlanets();

        if (planets.size() != new HashSet<>(planets).size()) //set cannot have duplicates
            throw new DuplicatePlanetsException();


        //Every system has at most three planets.
        if (systems.stream().anyMatch(s -> s.getPlanets().size() > 3))
            throw new MoreThan3PlanetsException();

        return true;
    }

    public List<Planet> getPlanets() {
        return systems
                .stream()
                .map(s -> s.getPlanets())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Planet> getPlanets(Player player) {
        return systems
                .stream()
                .filter(s -> s.controlledBy() == player)
                .map(s -> s.getPlanets())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Unit> getShipsSorted(Player p) {
        return systems
                .stream()
                .map(sys -> sys.getUnits())
                .flatMap(List::stream)
                .filter(unit -> unit.getOwner().equals(p))
                .sorted()
                .collect(Collectors.toList());

    }
}

