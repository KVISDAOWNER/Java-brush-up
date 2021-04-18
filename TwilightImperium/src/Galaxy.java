import java.util.ArrayList;
import java.util.List;



public class Galaxy {
    //Overvej andet end list - måske en form for set (så der ikke kan være duplicates?
    List<System> systems = new ArrayList<>();

    Galaxy() { //Default map setup
        Player blue = new Player(Race.THE_CLAN_OF_SAAR, Color.Blue);
        Player red = new Player(Race.THE_EMIRATES_OF_HACAN, Color.Red);

        SpawnDefaultSystems();
        SpawnDefaultShips(blue, red);
    }

    private void SpawnDefaultSystems(){
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

    private void SpawnDefaultShips(Player blue, Player red){
        System centerSys = systems.stream()
                .filter(s -> s.getPosition().equals(Position.CENTER))  //filter returns a lazy (intermediate representation) stream so not inefficient - recall from functional programming?
                .findFirst()
                .orElseThrow(); //throw if no match

        centerSys.enter(spawnShip("DREADNOUGHT", blue));
        centerSys.enter(spawnShip("DREADNOUGHT", blue));
        centerSys.enter(spawnShip("DESTROYER", blue));

        System northSys = systems.stream()
                .filter(s -> s.getPosition() //filter returns a lazy (intermediate representation) stream so not inefficient - recall from functional programming?
                        .equals(Position.NORTH))
                .findFirst()
                .orElseThrow(); //throw if no match
        northSys.enter(spawnShip("CRUISER", red));
        northSys.enter(spawnShip("CRUISER", red));
        northSys.enter(spawnShip("CARRIER", red));
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
