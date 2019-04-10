package tribute.inventory;

public enum Weapon {

    // TODO: Balance the weapons

    ROCK("Rock", 10),
    STICK("Stick", 15),
    SWORD("Sword", 40),
    BATTLEAXE("Battle Axe", 35),
    TRIDENT("Trident", 45, true),
    BOW("Bow", 30, true, "Arrow"),
    CROSSBOW("Crossbow", 35, true, "Arrow");

    private final String name;
    private final int damage;

    private final boolean ranged;
    private final boolean needsAmmo;
    private final String ammoName;

    Weapon(final String name, final int damage) {
        this.name = name;
        this.damage = damage;
        this.ranged = false;
        this.needsAmmo = false;
        this.ammoName = null;
    }

    Weapon(final String name, final int damage, final boolean ranged) {
        this.name = name;
        this.damage = damage;
        this.ranged = ranged;
        this.needsAmmo = false;
        this.ammoName = null;
    }

    Weapon(final String name, final int damage, final boolean ranged, final String ammoName) {
        this.name = name;
        this.damage = damage;
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

    public boolean isRanged() {
        return this.ranged;
    }

    public boolean isNeedsAmmo() {
        return this.needsAmmo;
    }

    public String getAmmoName() {
        return this.ammoName;
    }
}