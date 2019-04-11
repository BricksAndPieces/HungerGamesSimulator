package tribute.inventory;

public enum Food {

    // TODO: Balance the food

    APPLE("Apple", 5, 2),
    COOKIE("Cookie", 10, 5),
    FISH("Fish", 20, 8),
    SQUIRREL("Squirrel", 15, 6);

    private final String name;
    private final int health;
    private final int rarity;

    Food(final String name, final int health, final int rarity) {
        this.name = name;
        this.health = health;
        this.rarity = rarity;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getRarity() {
        return this.rarity;
    }

    public static Food getRandom() {
        double sum = 0;
        for(final Food food : values())
            sum += food.rarity;

        final double rand = Math.random() * sum;
        for(final Food food : values()) {
            sum -= food.rarity;

            if(sum < rand)
                return food;
        }

        throw new RuntimeException("This should never happen");
    }
}