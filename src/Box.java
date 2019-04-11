
/* TODO: ICONS, CONNECT BUTTONS TO ACTUAL FUNCTIONS, CHANGE THE BACKGROUND TO A CUSTOM BACKDROP, MORE BUTTONS */

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class Box extends JFrame implements ActionListener {

    //Variable
    public final boolean sizable = false; //Able to resize box

    public static final long serialVersionUID = 1L;

    public static void main(String[] args){
        //Makes the actual box visible
        new Box().setVisible(true);
    }

    private Box(){
        super("Hunger Games Simulation");     //Appears at the top of the box. AKA the title for the box.
        setSize(600,600);             //Size of the box
        setResizable(sizable);                       //Being able to change the size of the box -best to leave it false
        setDefaultCloseOperation(EXIT_ON_CLOSE);     //Able to close the box
        setLayout(new BorderLayout());               //Sets the layout of the buttons

        /* LAYOUTS:
         * FlowLayout
         * GridBagLayout
         * GridLayout
         * BorderLayout
         */

        JButton button = new JButton("Click"); //Makes a button with title: "Click"
        // *Changes button title to something else*
        // button.setActionCommand(something other than "Click")
        button.addActionListener(this);          //Gives the button a command @actionPerformed

        //ADDs -- Actually puts the buttons onto the box
        add(button, BorderLayout.SOUTH); //"BorderLayout.SOUTH" - puts the button at the bottom
        //                     - OPTIONS: NORTH, EAST, WEST, SOUTH
    }

    @Override
    public void actionPerformed(ActionEvent e){ //ACTION LISTENER
        String name = e.getActionCommand();         //Gets the button that you clicked

        if(name.equals("Click")){                   //If you click on the button titled "Click"
            System.out.println("Hello");            //Prints in the console
        }

    }

}