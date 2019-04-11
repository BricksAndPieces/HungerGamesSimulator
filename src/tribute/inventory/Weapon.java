package tribute.inventory;

public enum Weapon {

    // TODO: Balance the weapons

    ROCK("Rock", 10, 0.2),
    STICK("Stick", 15, 0.9),
    SWORD("Sword", 40, 0.1),
    BATTLEAXE("Battle Axe", 35, 0.2),
    TRIDENT("Trident", 45, 0.05,  true),
    BOW("Bow", 30, 0.3, true, "Arrow"),
    CROSSBOW("Crossbow", 35, 0.1, true, "Arrow");

    private final String name;
    private final int damage;
    private final double rarity;

    private final boolean ranged;
    private final boolean needsAmmo;
    private final String ammoName;

    Weapon(final String name, final int damage, final double rarity) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
        this.ranged = false;
        this.needsAmmo = false;
        this.ammoName = null;
    }

    Weapon(final String name, final int damage, final double rarity, final boolean ranged) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
        this.ranged = ranged;
        this.needsAmmo = false;
        this.ammoName = null;
    }

    Weapon(final String name, final int damage, final double rarity, final boolean ranged, final String ammoName) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
        this.ranged = ranged;
        this.needsAmmo = true;
        this.ammoName = ammoName;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public double getRarity() {
        return this.rarity;
    }

    public boolean isRanged() {
        return this.ranged;
    }

    public boolean isNeedsAmmo() {
        return this.needsAmmo;
    }

    public String getAmmoName() {
        return this.ammoName;
    }

    public static Weapon getRandom() {
        double sum = 0;
        for(final Weapon weapon : values())
            sum += weapon.rarity;

        final double rand = Math.random() * sum;
        for(final Weapon weapon : values()) {
            sum -= weapon.rarity;

            if(sum < rand)
                return weapon;
        }

        throw new RuntimeException("This should never happen");
    }
}