import java.util.ArrayList;
import java.util.List;



public class Galaxy {
    //Overvej andet end list - måske en form for set (så der ikke kan være duplicates?
    List<System> systems = new ArrayList<>();

    Galaxy() { //Default map setup
        Player blue = new Player(Race.THE_CLAN_OF_SAAR, Color.Blue);
        Player red = new Player(Race.THE_EMIRATES_OF_HACAN, Color.Red);

        spawnDefaultSystems();
        spawnDefaultShips(blue, red);
    }

    private void spawnDefaultSystems(){
        List<Planet> centerPlanets = new ArrayList<>();
        centerPlanets.add(Planet.MECATOLREX);
        systems.add( new System(centerPlanets, Position.CENTER));

        List<Planet> northPlanets = new ArrayList<>();
        northPlanets.add(Planet.VEGAMINOR);
        northPlanets.add(Planet.VEGAMAJOR);
        systems.add( new System(northPlanets, Position.NORTH));

        List<Planet> northEastPlanets = new ArrayList<>();
        systems.add( new System(northEastPlanets, Position.NORTH_EAST)); //empty system

        List<Planet> southEastPlanets = new ArrayList<>();
        southEastPlanets.add(Planet.INDUSTREX);
        systems.add( new System(southEastPlanets, Position.SOUTH_EAST));

        List<Planet> southPlanets = new ArrayList<>();
        southPlanets.add(Planet.RIGEL1);
        southPlanets.add(Planet.RIGEL2);
        systems.add( new System(southPlanets, Position.SOUTH));

        List<Planet> southWestPlanets = new ArrayList<>();
        southWestPlanets.add(Planet.RIGEL1);
        southWestPlanets.add(Planet.RIGEL2);
        systems.add( new System(southWestPlanets, Position.SOUTH_WEST));

        List<Planet> northWestPlanets = new ArrayList<>();
        northWestPlanets.add(Planet.MIRAGE);
        systems.add( new System(northWestPlanets, Position.NORTH_WEST));
    }

    private void spawnDefaultShips(Player blue, Player red){
        var center = getSystem(Position.CENTER);
        center.enter(spawnShip("DREADNOUGHT", blue));
        center.enter(spawnShip("DREADNOUGHT", blue));
        center.enter(spawnShip("DESTROYER", blue));

        var north = getSystem(Position.NORTH);
        north.enter(spawnShip("CRUISER", red));
        north.enter(spawnShip("CRUISER", red));
        north.enter(spawnShip("CARRIER", red));
    }

    private System getSystem(Position p){
        return  systems.stream()
                .filter(s -> s.getPosition().equals(p))  //filter returns a lazy (intermediate representation) stream so not inefficient - recall from functional programming?
                .findFirst()
                .orElseThrow(); //throw if no match
    }

    private Ship spawnShip(String shipName, Player p){
        Ship s;

        switch (shipName){
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
}
