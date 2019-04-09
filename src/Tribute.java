import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tribute {

    private final String name;
    private final BufferedImage icon;

    private final List<Inventory.Weapon> weapons;
    private final List<Inventory.Food> food;

    private boolean dead;
    private int health;
    private int skill;

    public Tribute(final String name, final BufferedImage icon) {
        this.name = name;
        this.icon = icon;

        this.weapons = new ArrayList<>();
        this.food = new ArrayList<>();

        this.dead = false;
        this.health = 100;
        this.skill = 1;
    }

    public String getName() {
        return this.name;
    }

    public BufferedImage getIcon() {
        return this.icon;
    }

    public boolean hasWeapon(final Inventory.Weapon w) {
        return this.weapons.contains(w);
    }

    public void findWeapon(final Inventory.Weapon w) {
        this.weapons.add(w);
    }

    public void discardWeapon(final Inventory.Weapon w) {
        if(this.weapons.contains(w))
            this.weapons.remove(w);
    }

    public List<Inventory.Weapon> getWeapons() {
        return Collections.unmodifiableList(this.weapons);
    }

    public boolean hasFood(final Inventory.Food f) {
        return this.food.contains(f);
    }

    public void findFood(final Inventory.Food f) {
        this.food.add(f);
    }

    public void eatFood(final Inventory.Food f) {
        if(this.food.contains(f)) {
            this.regainHealth(f.getHealth());
            this.food.remove(f);
        }
    }

    public List<Inventory.Food> getFood() {
        return Collections.unmodifiableList(this.food);
    }

    public boolean isDead() {
        return this.dead;
    }

    public void kill() {
        this.dead = true;
    }

    public void revive() {
        this.dead = false;
    }

    public int getHealth() {
        return this.health;
    }

    public void regainHealth(final int n) {
        this.health = Math.min(health+n, 100);
    }

    public boolean loseHealth(final int n) {
        this.health = Math.min(health-n, 0);

        if(this.health == 0) {
            this.kill();
            return true;
        }

        return false;
    }

    public int getSkill() {
        return this.skill;
    }

    public void gainSkill() {
        this.skill++;
    }

    @Override
    public String toString() {
        return String.format("Tribute{name=%s,health=%d,skill=%d}", this.name, this.health, this.skill);
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Tribute && obj.toString().equals(this.toString());
    }
}