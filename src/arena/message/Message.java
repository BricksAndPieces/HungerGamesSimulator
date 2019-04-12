package arena.message;

import tribute.Tribute;

import java.util.Arrays;

public class Message {

    private final String[] data;
    private final String format;

    private final Tribute[] groupZero;
    private final Tribute[] groupOne;

    private final boolean lethal;
    private final Tribute tribute;

    public Message(final String data, final Tribute... tributes) {
        this.data = data.split("\\|");
        if(tributes.length < 2)
            throw new IllegalArgumentException("2+ Tributes must be provided");

        final int half = tributes.length / 2;
        this.groupZero = Arrays.copyOfRange(tributes, 0, half);
        this.groupOne = Arrays.copyOf(tributes, half);

        this.lethal = Boolean.valueOf(getValue("lethal"));
        this.tribute = this.lethal ? null : groupOne[0];









        this.format = getValue("format");
        String x = getValue("fsdf");
    }










    public boolean isLethal() {
        return this.lethal;
    }

    public String getText() {
        return this.format.replace("{t0}", formatTributes(groupZero)).replace("{t1}", formatTributes(groupOne));
    }

    private String getValue(final String key) {
        for(final String entry : this.data) {
            if(entry.startsWith(key+":"))
                return entry.substring(key.length()+1).trim();
        }

        return null;
    }

    private String formatTributes(final Tribute[] tributes) {
        if(tributes.length == 1)
            return tributes[0].getName();

        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tributes.length-1; i++)
            sb.append(tributes[i]).append(", ");

        return sb.toString() + "and " + tributes[tributes.length-1].getName();
    }
}