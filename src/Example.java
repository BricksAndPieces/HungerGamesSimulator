import simulation.HungerGames;
import simulation.HungerGamesBuilder;
import tribute.Tribute;
import tribute.inventory.Food;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class Example {

    public static void main(final String[] args) throws Exception {

        // nulls are where images go

        HungerGames hg = new HungerGamesBuilder()
                .addTribute(new Tribute("Bob", null, 1))
                .addTribute(new Tribute("Joe", null, 2))
                .build();

        while(!hg.finished()) {
            hg.nextEvent();
            // Do whatever
        }

    }
}