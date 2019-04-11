package tribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Alliance {

    private final List<Tribute> members;

    public Alliance(final Tribute... tributes) {
        this.members = new ArrayList<>();
        this.members.addAll(Arrays.asList(tributes));
    }

    public boolean isMember(final Tribute tribute) {
        return this.members.contains(tribute);
    }

    public void join(final Tribute tribute) {
        if(!this.members.contains(tribute))
            this.members.add(tribute);
    }

    public void leaveAlliance(final Tribute tribute) {
        if(this.members.contains(tribute))
            this.members.remove(tribute);
    }

    public List<Tribute> getMembers() {
        return Collections.unmodifiableList(members);
    }
}