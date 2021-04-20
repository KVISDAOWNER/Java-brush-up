package players;

import java.util.Objects;

public class Player {
    private String name;
    private Race race;
    private Color color;

    public Player(Race race, Color color) {
        this("players", race, color);
    }

    public Player(String name, Race race, Color color) {
        this.name = name;
        this.race = race;
        this.color = color.c;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && race == player.race && color == player.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, race, color);
    }

    @Override
    public String toString() {
        return color.toString() + ": " + name;
    }
}
