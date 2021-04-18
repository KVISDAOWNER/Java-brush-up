import Galaxy.Galaxy;
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

        Galaxy g = new Galaxy();
        java.lang.System.out.println(g.getShips(g.getBlue()));
        java.lang.System.out.println(g.getShips(g.getRed()));


    }
}
