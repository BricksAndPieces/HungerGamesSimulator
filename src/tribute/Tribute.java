package tribute;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tribute {

    private final String name;
    private final BufferedImage icon;

    private final List<Inventory.Weapon> weapons;
    private final List<Inventory.Food> food;

    private Alliance alliance;

    private boolean dead;
    private int health;
    private int skill;

    public Tribute(final String name, final BufferedImage icon) {
        this.name = name;
        this.icon = icon;

        this.weapons = new ArrayList<>();
        this.food = new ArrayList<>();

        this.alliance = null;

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

    public boolean hasWeapon(final Inventory.Weapon weapon) {
        return this.weapons.contains(weapon);
    }

    public void findWeapon(final Inventory.Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void discardWeapon(final Inventory.Weapon weapon) {
        if(this.weapons.contains(weapon))
            this.weapons.remove(weapon);
    }

    public List<Inventory.Weapon> getWeapons() {
        return Collections.unmodifiableList(this.weapons);
    }

    public boolean hasFood(final Inventory.Food food) {
        return this.food.contains(food);
    }

    public void findFood(final Inventory.Food food) {
        this.food.add(food);
    }

    public void eatFood(final Inventory.Food food) {
        if(this.food.contains(food)) {
            this.regainHealth(food.getHealth());
            this.food.remove(food);
        }
    }

    public List<Inventory.Food> getFood() {
        return Collections.unmodifiableList(this.food);
    }

    public Alliance getAlliance() {
        return this.alliance;
    }

    public boolean inAlliance() {
        return this.alliance != null;
    }

    public void joinAlliance(final Alliance alliance) {
        this.leaveAlliance();

        this.alliance = alliance;
        this.alliance.join(this);
    }

    public void leaveAlliance() {
        if(this.alliance != null)
            this.alliance.leaveAlliance(this);
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

    public void regainHealth(final int regain) {
        this.health = Math.min(health+regain, 100);
    }

    public boolean loseHealth(final int lose) {
        this.health = Math.min(health-lose, 0);

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
        return String.format("tribute.Tribute{name=%s,health=%d,skill=%d}", this.name, this.health, this.skill);
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Tribute && obj.toString().equals(this.toString());
    }
}