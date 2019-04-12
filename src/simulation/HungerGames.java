package simulation;

import tribute.Tribute;

import java.util.ArrayList;
import java.util.List;

public class HungerGames {

    private final List<Tribute> tributes;
    private final List<Alliance> alliances;

    public HungerGames(final List<Tribute> tributes) {
        this.tributes = tributes;
        this.alliances = new ArrayList<>();
    }

    public Object nextEvent() {
        return new Object();
    }

    public boolean finished() {
        return true;
    }

    // i dunno what else to put here lol
}