package systems;

class TooManyPlanetsException extends IllegalArgumentException {
    TooManyPlanetsException(int planets) {
        super("Illegal number of planets. Received " + planets + " planets");
    }
}
