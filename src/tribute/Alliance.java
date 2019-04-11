package tribute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that defines a single Alliance in the Hunger Games
 * An Alliance is a easy to use Wrapper for the Tributes
 */
public class Alliance {

    private final List<Tribute> members;

    /**
     * Constructor for the Alliance class
     * Creates a new List of Tributes and fills it with the Tributes given as a parameter
     *
     * @param tributes
     * The Tributes to form the new Alliance, can be empty
     */
    public Alliance(final Tribute... tributes) {
        this.members = new ArrayList<>();
        for(final Tribute tribute : tributes)
            tribute.joinAlliance(this);
    }

    /**
     * Checks whether or not a Tribute is in this Alliance
     *
     * @param tribute
     * The Tribute to check for in this Alliance
     *
     * @return
     * Returns true if the given Tribute is a member of this Alliance, else returns false
     */
    public boolean isMember(final Tribute tribute) {
        return this.members.contains(tribute);
    }

    /**
     * Adds a tribute to an Alliance
     *
     * @param tribute
     * The Tribute to add to this Alliance
     */
    protected void add(final Tribute tribute) {
        if(!this.members.contains(tribute))
            this.members.add(tribute);
    }

    /**
     * Removes a Tribute from this Alliance
     *
     * @param tribute
     * The Tribute to remove from this Alliance
     *
     */
    protected void remove(final Tribute tribute) {
        if(this.members.contains(tribute))
            this.members.remove(tribute);
    }

    /**
     * All the Tributes in this Alliance
     *
     * @return
     * Returns an unmodifiable list of all The Tributes
     */
    public List<Tribute> getMembers() {
        return Collections.unmodifiableList(members);
    }

    /**
     * The String representation of this an Alliance object
     *
     * @return
     * An easy to ready String representation of the Alliance object for easy debugging
     */
    @Override
    public String toString() {
        return String.format("Alliance{members=%s}", this.members.toString());
    }

    /**
     * Checks if the Alliance is equal to another Alliance
     *
     * @param obj
     * The object to compare against
     *
     * @return
     * Returns true if it is the same Alliance, else returns false
     */
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Alliance && this.members.containsAll(((Alliance) obj).members);
    }
}