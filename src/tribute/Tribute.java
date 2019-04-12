package tribute;

import tribute.inventory.Food;
import tribute.inventory.Weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that defines a single tribute in the Hunger Games
 * Each tribute has a variety of characteristics
 */
public class Tribute {

    private final String name;
    private final BufferedImage icon;
    private final int district;

    private final List<Weapon> weapons;
    private final List<Food> food;

    private boolean dead;
    private int health;
    private int skill;

    /**
     * Constructor for a Tribute object
     * Only name and icon are required, all other characteristics are automatically set
     *
     * @param name
     * The name of the Tribute
     *
     * @param icon
     * The avatar to be used for the corresponding Tribute
     */
    public Tribute(final String name, final BufferedImage icon, final int district) {
        this.name = name;
        this.icon = icon;
        this.district = district;

        this.weapons = new ArrayList<>();
        this.food = new ArrayList<>();

        this.dead = false;
        this.health = 100;
        this.skill = 1;
    }

    /**
     * The corresponding name of the Tribute
     *
     * @return
     * String representation of the Tributes name
     */
    public String getName() {
        return this.name;
    }

    /**
     * The image to be used for the Tribute
     *
     * @return
     * BufferedImage representation of image
     */
    public BufferedImage getIcon() {
        return this.icon;
    }

    /**
     * The district the Tribute is part of
     *
     * @return
     * The integer value representation of the Tribute's district
     */
    public int getDistrict() {
        return this.district;
    }

    /**
     * Checks whether or not the Tribute has a certain weapon.
     *
     * @param weapon
     * The particular weapon to check
     *
     * @return
     * Returns true if the Tribute has the weapon, else returns false
     */
    public boolean hasWeapon(final Weapon weapon) {
        return this.weapons.contains(weapon);
    }

    /**
     * Adds a weapon to the Tribute's inventory
     *
     * @param weapon
     * The weapon to add to inventory
     */
    public void findWeapon(final Weapon weapon) {
        this.weapons.add(weapon);
    }

    /**
     * Removes a weapon from the Tribute's inventory
     *
     * @param weapon
     * The weapon to remove from inventory
     */
    public void discardWeapon(final Weapon weapon) {
        if(this.weapons.contains(weapon))
            this.weapons.remove(weapon);
    }

    /**
     * All weapons a Tribute currently has in their inventory
     *
     * @return
     * A list of all weapons currently in the Tribute's inventory
     */
    public List<Weapon> getWeapons() {
        return Collections.unmodifiableList(this.weapons);
    }

    /**
     * Checks whether a Tribute has a certain food in their inventory
     *
     * @param food
     * The particular food to check
     *
     * @return
     * Returns true if the Tribute has the food, else returns false
     */
    public boolean hasFood(final Food food) {
        return this.food.contains(food);
    }

    /**
     * Adds a food to the Tribute's inventory
     *
     * @param food
     * The food to add to inventory
     */
    public void findFood(final Food food) {
        this.food.add(food);
    }

    /**
     * Removes a food item from the Tribute's inventory and regains the corresponding amount of health
     *
     * @param food
     * The food item to be consumed
     */
    public void eatFood(final Food food) {
        if(this.food.contains(food)) {
            this.regainHealth(food.getHealth());
            this.food.remove(food);
        }
    }

    /**
     * All foods a Tribute currently has in their inventory
     *
     * @return
     * A list of all foods currently in the Tribute's inventory
     */
    public List<Food> getFood() {
        return Collections.unmodifiableList(this.food);
    }

    /**
     * The current living state of the Tribute
     *
     * @return
     * Returns true if the Tribute is dead, else returns false
     */
    public boolean isDead() {
        return this.dead;
    }

    /**
     * Kills the Tribute, isDead() will now return true
     */
    public void kill() {
        this.dead = true;
        this.health = 0;
    }

    /**
     * The current health of the Tribute from 0 - 100
     *
     * @return
     * The health of the Tribute
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Allows the tribute to regain health.
     * Max amount of health a Tribute can achieve is 100
     *
     * @param regain
     * Amount of health to regain
     */
    public void regainHealth(final int regain) {
        this.health = Math.min(health+regain, 100);
    }

    /**
     * Causes the tribute to lose health.
     * The min amount of health a Tribute can have is 0
     *
     * @param lose
     * The amount of health to lose
     *
     * @return
     * returns whether or not the Tribute died due to losing health
     */
    public boolean loseHealth(final int lose) {
        this.health = Math.min(health-lose, 0);

        if(this.health == 0) {
            this.kill();
            return true;
        }

        return false;
    }

    /**
     * The amount of skill a Tribute has.
     * The more kills a Tribute gains, the more skill they have
     *
     * @return
     * The never negative amount of skill a Tribute has
     */
    public int getSkill() {
        return this.skill;
    }

    /**
     * Increments the Tribute's skill by 1
     */
    public void gainSkill() {
        this.skill++;
    }

    /**
     * The String representation of the Tribute used for easy debugging
     *
     * @return
     * A String representation of the Tribute object
     */
    @Override
    public String toString() {
        return String.format("Tribute{name=%s,health=%d,skill=%d}", this.name, this.health, this.skill);
    }

    /**
     * Checks whether or not the Tribute is equal to another object
     *
     * @param obj
     * The object to check against
     *
     * @return
     * Returns true if the Object is equal to the Tribute, else returns false
     */
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Tribute && obj.toString().equals(this.toString());
    }
}