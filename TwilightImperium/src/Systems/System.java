package Systems;

import Galaxy.Position;
import Planets.Planet;
import Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class System {
    private List<Planet> planets = new ArrayList<>();
    private List<Unit> units = new ArrayList<>();
    private Position pos;

    public System(List<Planet> ps, Position p) {
        if (ps.size() > 3)
            throw new TooManyPlanetsException(ps.size());
        this.planets = ps;
        this.pos = p;
    }
    System(List<Planet> ps, List<Unit> us, Position p) {
        this(ps, p);
        this.units = us;
    }

    public void enter(Unit u) {
        units.add(u);
    }

    public void leave(Unit u) {
        units.remove(u);

        //flex way :D
        //units = units.stream().filter(s -> !s.equals(u)).collect(Collectors.toList());
    }

    public List<Unit> getUnits() {
        return units;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public Position getPosition() {
        return pos;
    }
}

