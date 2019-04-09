import weapons.Weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Tribute {

    private final String name;
    private final BufferedImage icon;

    private final boolean male;
    private final int district;

    private final List<Weapon> weapons;

    private int health;

    private boolean dead;

    public Tribute(final Object data) {
        name ="";
        weapons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void regainHealth(final int n) {
        this.health += n;
    }

    public boolean loseHealth() {
        return true; //TODO: bfikdsnfjlsnjkndjsnfkjdsnfkjsdnkfndkjnfjkdsnfkjdnkjfndskjnfkjdsnfkjdsnkfjsdnkfnkjdsnfkndkfnsdjfnsdkj
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

    public boolean isMale() {
        return this.male;
    }

    public int getDistrict() {
        return this.district;
    }
}