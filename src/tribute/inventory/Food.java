package tribute.inventory;

public enum Food {

    // TODO: Balance the food

    APPLE("Apple", 5),
    COOKIE("Cookie", 10),
    FISH("Fish", 20),
    SQUIRREL("Squirrel", 15);

    private final String name;
    private final int health;

    Food(final String name, final int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public String toString() {
        return this.name;
    }
}