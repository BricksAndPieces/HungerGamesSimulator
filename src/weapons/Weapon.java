package weapons;

public interface Weapon {

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @return
     */
    String getDescription();

    /**
     *
     * @return
     */
    int getDamage();

    /**
     *
     * @return
     */
    boolean isRanged();
}