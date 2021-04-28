package systems;

import galaxy.Position;
import planets.Planet;
import players.Player;
import units.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public System(List<Planet> ps, List<Unit> us, Position p) {
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

    public Set<Player> controlledBy() {
        Set<Player> players = new HashSet<>();
        for (Unit unit : units) {
            players.add(unit.getOwner());
        }
        return players;
    }
}

