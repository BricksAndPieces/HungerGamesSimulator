package simulation;

import tribute.Tribute;

import java.util.ArrayList;
import java.util.List;

public class HungerGamesBuilder {

    private final List<Tribute> tributes;

    public HungerGamesBuilder() {
        this.tributes = new ArrayList<>();
    }

    public boolean containsTribute(final Tribute tribute) {
        return this.tributes.contains(tribute);
    }

    public HungerGamesBuilder addTribute(final Tribute tribute) {
        if(!this.containsTribute(tribute))
            this.tributes.add(tribute);

        return this;
    }

    public HungerGamesBuilder addTributes(final Tribute... tributes) {
        for(Tribute tribute : tributes)
            this.addTribute(tribute);

        return this;
    }

    public HungerGamesBuilder removeTribute(final Tribute tribute) {
        if(this.containsTribute(tribute))
            this.tributes.remove(tribute);

        return this;
    }

    public HungerGamesBuilder removeTributes(final Tribute... tributes) {
        for(Tribute tribute : tributes)
            this.removeTribute(tribute);

        return this;
    }

    public HungerGames build() {
        return new HungerGames(this.tributes);
    }
}