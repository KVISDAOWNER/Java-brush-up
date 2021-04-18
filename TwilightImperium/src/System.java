import java.util.ArrayList;
import java.util.List;

public class System {
    private List<Planet> neighbors = new ArrayList<>();
    private List<Unit> units = new ArrayList<>();
    private Position pos;

    System(List<Planet> ns, Position p) {
        if (ns.size() > 3)
            throw new TooManyPlanetsException(ns.size());
        this.neighbors = ns;
        this.pos = p;
    }
    System(List<Planet> ns, List<Unit> us, Position p) {
        this(ns, p);
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

    public Position getPosition() {
        return pos;
    }
}

class TooManyPlanetsException extends IllegalArgumentException {
    TooManyPlanetsException(int planets) {
        super("Illegal number of planets. Received " + planets + " planets");
    }
}