import Galaxy.*;
import IO.Scoreboard;
import Planets.Planet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Planet> planets = new ArrayList<>();
        planets.add(Planet.MIRAGE);
        planets.add(Planet.VEGAMAJOR);
        planets.add(Planet.VELNOR);

        java.lang.System.out.println(planets);

        Galaxy g = null;
        try {
            g = new Galaxy();
        } catch (DuplicatePlanetsException | IllegalCenterException | MoreThan3PlanetsException e) {
            e.printStackTrace();
        }
        java.lang.System.out.println(g.getShipsSorted(g.getBluePlayer()));
        java.lang.System.out.println(g.getShipsSorted(g.getRedPlayer()));

        Scoreboard.writeScoreboard(g);
    }
}
