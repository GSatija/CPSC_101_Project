package gui;

import Player.Player;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiHandler {

    Player player1;
    Player player2;
    Color bg = new Color(176, 196, 222);
    Color side = new Color(240, 248, 255);
    Color bottom = new Color(220, 220, 220);
    PaintComponent board= new PaintComponent(player1, player2);

    public void createWindow(Player p1, Player p2) {

        player1 = p1;
        player2 = p2;

        JFrame jf = new JFrame("Team Caffeine - Score Four");
        jf.setSize(1280, 900);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("images\\logo.png");
        jf.setIconImage(logo.getImage());

        JButton submit = new JButton("Submit");
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int i=0;
                while(i<16){
                    board.myPegs[i].clearPeg();
                    i++; 
                }
                board.repaint();
            }
        });
        submit.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }    
        });
        quit.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        JTextArea textBox = new JTextArea();
        textBox.setEditable(false);

        board = new PaintComponent(player1,player2);

        JPanel area = new JPanel(new BorderLayout());
        area.setSize(1200, 820);
        area.setBackground(bg);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new GridLayout(10, 0, 0, 20));
        sideBar.setPreferredSize(new Dimension(150, 900));
        sideBar.setBackground(side);

        
        sideBar.add(textBox);
        sideBar.add(submit);
        sideBar.add(restart);
        sideBar.add(quit);

        JLabel label = new JLabel("It is Currently " + player1.getName() + "'s turn.");

        JPanel p3 = new JPanel();
        p3.setBackground(bottom);
        p3.add(label);

        area.add(board, BorderLayout.CENTER);

        jf.add(area);
        jf.add(p3, BorderLayout.PAGE_END);
        jf.add(sideBar, BorderLayout.EAST);
        jf.setVisible(true);

        System.out.println(player1.getName());
        System.out.println(player2.getName());
        System.out.println(player1.getColour());
        System.out.println(player2.getColour());
    }

}