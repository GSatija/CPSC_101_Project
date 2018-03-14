package scorefour;

import Player.Player;
import gui.GuiHandler;
import javax.swing.JOptionPane;

public class Game {

    String name1;
    String name2;
    String colour;
    String colour2;
    GuiHandler gui = new GuiHandler();
    Boolean colourBoolean = false;
    Boolean nameBoolean = false;

    public void startGame() {
        name1 = JOptionPane.showInputDialog(null, "Player 1,\nPlease Enter Your name: ",JOptionPane.CANCEL_OPTION);
        if(name1==null){
         System.exit(0);   
        }
        while (nameBoolean
                == false) {
            if (name1 != null && !name1.isEmpty()) {
                nameBoolean = true;
            } else {
                name1 = JOptionPane.showInputDialog(null, "" + name1 + "\nPlease enter a name:", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            }
        }

        colour = JOptionPane.showInputDialog(null, "Hello, " + name1 + "!\nPlease pick your colour (white or black):");

        while (colourBoolean
                == false) {
            colour = colour.toLowerCase();

            if (colour.equals("white") || colour.equals("black")) {

                JOptionPane.showMessageDialog(null, "Your bead colour is " + colour + ". Press OK to continue.", "Colour Set", JOptionPane.NO_OPTION);
                colourBoolean = true;

            } else {

                colour = JOptionPane.showInputDialog(null, "" + name1 + ", \nPlease choose either White or Black:", "Invalid Colour", JOptionPane.ERROR_MESSAGE);
            }
        }

        nameBoolean = false;
        name2 = JOptionPane.showInputDialog(null, "Player 2,\nPlease Enter Your name:");

        if (colour.equals(
                "black")) {
            colour2 = "white";
        } else {
            colour2 = "black";
        }

        while (nameBoolean
                == false) {
            if (name2 != null && !name2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Your bead colour is " + colour2 + ". Press OK to start the game.", "Game Starting", JOptionPane.NO_OPTION);
                nameBoolean = true;
            } else {
                name2 = JOptionPane.showInputDialog(null, "" + name2 + "\nPlease enter a name: ", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            }
        }
        Player player1 = new Player(name1, colour);
        Player player2 = new Player(name2, colour2);

        gui.createWindow(player1, player2);
    }

    public String getName(int x) {
        if (x == 1) {
            return name1;
        } else {
            return name2;
        }
    }

    public String getColour(int x) {

        if (x == 1) {
            return colour;
        } else if (colour.equals("black")) {
            colour2 = "white";
        } else {
            colour2 = "black";
        }
        return colour2;
    }
}
