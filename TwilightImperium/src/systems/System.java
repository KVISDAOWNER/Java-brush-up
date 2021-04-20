package systems;

import galaxy.Position;
import planets.Planet;
import players.Player;
import units.Unit;

import java.util.ArrayList;
import java.util.List;

public class System {
    private List<Planet> planets = new ArrayList<>();
    private List<Unit> units = new ArrayList<>();
    private Position pos;

    public System(List<Planet> planets, Position pos) {
        if (planets.size() > 3)
            throw new TooManyPlanetsException(planets.size());
        this.planets = planets;
        this.pos = pos;
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

    public Player controlledBy() {
        boolean red = false;
        boolean blue = false;

        Player owner = null;
        for (Unit u : units) {
            if (u.getOwner().equals(owner) || owner == null) //same owner of unit or first owner of unit encountered
                owner = u.getOwner();
            else //both have units in system
                return null;
        }
        return owner;
    }
}

