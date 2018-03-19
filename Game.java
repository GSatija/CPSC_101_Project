package ca.unbc.cpsc.score4;

import com.oracle.tools.packager.JreUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame {

    String name1 = "Player 1";
    String name2 = "Player 2";
    String colour;
    String colour2;
    GuiHandler gui = new GuiHandler();
    Boolean colourBoolean = false, playerBoolean = false, humanPlayer = false, compPlayer = false, player2 = false;
    Boolean computer=false;
    Boolean nameBoolean = false;
    private JLabel label;

    /**
     * Radio button thing- done
     * and players...
     * <p>
     * <p>
     * Need to work on this!
     */
    public void startGame() {

        int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                "Choose your opponent", //Object message,
                "Choose an option", //String title
                JOptionPane.YES_NO_OPTION, //int optionType
                JOptionPane.INFORMATION_MESSAGE, //int messageType
                null, //Icon icon,
                new String[]{"Human Player", "Jarvis"}, //Object[] options,
                "Jarvis");//Object initialValue
        if(choice == 0 ){
            //Metric was chosen
        }else{
            computer=true;
        }

        name1 = JOptionPane.showInputDialog(null, "Player 1,\nPlease Enter Your name: ");
        if (name1 == null) {
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
//        label = new JLabel("With whom you want to play?");
//        add(label, BorderLayout.CENTER);
//
//        JFrame frame1 = new JFrame();
//
//        frame1.setLocation(getX() / 2, getY() / 2);
//
//        JRadioButton humanButton = new JRadioButton("Human Player");
//        humanButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame1.setVisible(false);
//                humanPlayer = true;
//            }
//        });
//
//
//        JRadioButton compButton = new JRadioButton("Computer Player");
//        compButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame1.setVisible(false);
//                compPlayer = true;
//            }
//        });
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(humanButton);
//        group.add(compButton);
//
//        frame1.setLayout(new FlowLayout());
//
//        frame1.add(humanButton);
//        frame1.add(compButton);
//
//        frame1.pack();
//
//        frame1.setVisible(true);

//
//        JFrame frame = new JFrame();
//
//        label = new JLabel("Choose your color");
//        add(label, BorderLayout.CENTER);
//
//
//        JRadioButton whiteButton = new JRadioButton("White");
//        whiteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                frame.setVisible(false);
//                colour = "white";
//                colourBoolean = true;
//            }
//        });
//
//        JRadioButton blackButton = new JRadioButton("Black");
//        blackButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                frame.setVisible(false);
//
//                colour = "black";
//                colourBoolean = true;
//            }
//        });
//
//
//
//        ButtonGroup group2 = new ButtonGroup();
//        group2.add(whiteButton);
//        group2.add(blackButton);
//
//        frame.setLayout(new FlowLayout());
//
//        frame.add(whiteButton);
//        frame.add(blackButton);
//
//        frame.pack();
//
//        frame.setVisible(true);


//            if(colourBoolean==true){
//                frame.setVisible(false);
//            }


        if (humanPlayer == true) {


            name2 = JOptionPane.showInputDialog(null, "Player 2,\nPlease Enter Your name:");

            nameBoolean = false;
            if (colour.equals(
                    "black")) {
                colour2 = "white";
            } else {
                colour2 = "black";
            }
            if (name2 == null) {
                System.exit(0);
            }


            while (nameBoolean
                    == false) {
                if (name2 != null && !name2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Your bead colour is " + colour2 + ". Press OK to start the game.", "Game Starting", JOptionPane.NO_OPTION);
                    nameBoolean = true;
                    player2 = true;
                } else {
                    name2 = JOptionPane.showInputDialog(null, "" + name2 + "\nPlease enter a name: ", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                }
            }



        }


//
//        colour = JOptionPane.showInputDialog(null, "Hello, " + name1 + "!\nPlease pick your colour (white or black):");
//
//        while (colourBoolean
//                == false) {
//            colour = colour.toLowerCase();
//
//            if (colour.equals("white") || colour.equals("black")) {
//
//                JOptionPane.showMessageDialog(null, "Your bead colour is " + colour + ". Press OK to continue.", "Colour Set", JOptionPane.NO_OPTION);
//                colourBoolean = true;
//
//            } else {
//
//                colour = JOptionPane.showInputDialog(null, "" + name1 + ", \nPlease choose either White or Black:", "Invalid Colour", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//
//        nameBoolean = false;
//        name2 = JOptionPane.showInputDialog(null, "Player 2,\nPlease Enter Your name:");
//
//        if (colour.equals(
//                "black")) {
//            colour2 = "white";
//        } else {
//            colour2 = "black";
//        }
//
//        while (nameBoolean
//                == false) {
//            if (name2 != null && !name2.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Your bead colour is " + colour2 + ". Press OK to start the game.", "Game Starting", JOptionPane.NO_OPTION);
//                nameBoolean = true;
//            } else {
//                name2 = JOptionPane.showInputDialog(null, "" + name2 + "\nPlease enter a name: ", "Invalid Name", JOptionPane.ERROR_MESSAGE);
//            }
//        }

        if(computer==true){
            name2="Jarvis";
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

    class Reminder {
        java.util.Timer timer;

        public Reminder(int seconds) {
            timer = new Timer();
            timer.schedule(new RemindTask(), seconds * 1000);
        }

        class RemindTask extends TimerTask {
            public void run() {
                System.out.println("Time's up!");
                timer.cancel(); //Terminate the timer thread
            }
        }

        public void delay() {
            new Reminder(5);
            System.out.println("Task scheduled.");
        }


    }



}
