import galaxy.DuplicatePlanetsException;
import galaxy.Galaxy;
import galaxy.IllegalCenterException;
import galaxy.MoreThan3PlanetsException;
import IO.Scoreboard;
import planets.Planet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Planet> planets = new ArrayList<>();
        planets.add(Planet.MIRAGE);
        planets.add(Planet.VEGAMAJOR);
        planets.add(Planet.VELNOR);

        java.lang.System.out.println(planets);

        Galaxy galaxy = null;
        try {
            galaxy = new Galaxy();
        } catch (DuplicatePlanetsException | IllegalCenterException | MoreThan3PlanetsException e) {
            e.printStackTrace();
        }
        java.lang.System.out.println(galaxy.getShipsSorted(galaxy.getBluePlayer()));
        java.lang.System.out.println(galaxy.getShipsSorted(galaxy.getRedPlayer()));

        Scoreboard.writeScoreboard(galaxy);
        
    }
}
