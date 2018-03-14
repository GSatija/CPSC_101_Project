package gui;

import bead.Bead;
import board.Board;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import scorefour.Line;
import Player.Player;
import peg.Peg;

public class PaintComponent extends JComponent implements MouseListener {

    private final int myAx = 0;
    private final int myAy = 70;
    private final int myBx = 85;
    private final int myBy = 170;
    private final int myCx = 170;
    private final int myCy = 270;
    private final int myDx = 250;
    private final int myDy = 370;
    
    Player p1;
    Player p2;
    
    Line line=new Line();
    
    boolean click = false;
    
    Bead[] myBeads=new Bead[64];
    
    int turn=0;
    
    int beadX;
    int beadY;

    Board board = new Board();

    public PaintComponent(Player player1,Player player2) {
        addMouseListener(this);
        p1=player1;
        p2=player2;
    }

    public PaintComponent(int x, int y) {
        beadX = x;
        beadY = y;
    }
   
    public Peg[] myPegs = {new Peg(myAx, myAy, "A1"),
        new Peg(myAx + 207, myAy - 43, "A2"),
        new Peg(myAx + 413, myAy - 86, "A3"),
        new Peg(myAx + 620, myAy - 130, "A4"),
        new Peg(myBx, myBy, "B1"),
        new Peg(myBx + 207, myAy + 57, "B2"),
        new Peg(myBx + 413, myAy + 14, "B3"),
        new Peg(myBx + 637, myAy - 39, "B4"),
        new Peg(myCx, myCy, "C1"),
        new Peg(myCx + 207, myAy + 157, "C2"),
        new Peg(myCx + 413, myAy + 114, "C3"),
        new Peg(myCx + 653, myAy + 61, "C4"),
        new Peg(myDx, myDy, "D1"),
        new Peg(myDx + 225, myAy + 245, "D2"),
        new Peg(myDx + 450, myAy + 190, "D3"),
        new Peg(myDx + 675, myDy - 162, "D4")};

    @Override
    public void paintComponent(Graphics g) {

        try {
            Graphics2D g2 = (Graphics2D) g;

            board.draw(g2);
            int i = 0;
            for (Peg myPeg : myPegs) {

                String name = myPeg.getName();
                i++;
                myPeg.draw(g2);
            }

            /*if (player.getColour() == white && mouse click == true)
            {
            if peg.Height == 0
            Bead bead1 = new Bead(20, 395);
        }*/
            
            
            
            
            
            
            
            
//********************************************************//
//            if (click == true) {
//                Bead bead = new Bead(beadX, beadY);
//                bead.drawBlack(g2);
//            }*/
            



        } catch (IOException ex) {
            Logger.getLogger(PaintComponent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        beadX = e.getX();
        beadY = e.getY();
        findPeg(e.getX(),e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    public void findPeg(int x,int y){
        if (!click) {
            beadX = x;
            beadY = y;
            click = true;
        }
        repaint();
        if((beadX<85)&&(beadX>50)){
                if((beadY<470)&&(beadY>195)){
                    if(myPegs[0].getHeight()<4){
                        myBeads[turn]=new Bead(45,(470-(myPegs[0].getHeight()+1)*65),turn);
                        myPegs[0].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                       
                        
                        if(line.check(myPegs[0],0)){
                            System.err.println("won");
                        }else{
                            System.err.println("yes "+myPegs[0].getHeight());
                        }
                         repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX<290)&&(beadX>255)){
                if((beadY>155)&&(beadY<425)){
                    if(myPegs[1].getHeight()<4){
                        myBeads[turn]=new Bead(250,(425-(myPegs[1].getHeight()+1)*65),turn);
                        myPegs[1].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX<495)&&(beadX>460)){
                if((beadY>110)&&(beadY<385)){
                    if(myPegs[2].getHeight()<4){
                        myBeads[turn]=new Bead(455,(385-(myPegs[2].getHeight()+1)*65),turn);
                        myPegs[2].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX<705)&&(beadX>670)){
                if((beadY>70)&&(beadY<340)){
                    if(myPegs[3].getHeight()<4){
                        myBeads[turn]=new Bead(665,(340-(myPegs[3].getHeight()+1)*65),turn);
                        myPegs[3].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX<170)&&(beadX>135)){
                if((beadY>300)&&(beadY<570)){
                    if(myPegs[4].getHeight()<4){
                        myBeads[turn]=new Bead(130,(570-(myPegs[4].getHeight()+1)*65),turn);
                        myPegs[4].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>340)&&(beadX<375)){
                if((beadY>255)&&(beadY<525)){
                    if(myPegs[5].getHeight()<4){
                        myBeads[turn]=new Bead(335,(525-(myPegs[5].getHeight()+1)*65),turn);
                        myPegs[5].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>545)&&(beadX<580)){
                if((beadY>210)&&(beadY<435)){
                    if(myPegs[6].getHeight()<4){
                        myBeads[turn]=new Bead(540,(485-(myPegs[6].getHeight()+1)*65),turn);
                        myPegs[6].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>770)&&(beadX<805)){
                if((beadY>160)&&(beadY<380)){
                    if(myPegs[7].getHeight()<4){
                        myBeads[turn]=new Bead(765,(430-(myPegs[7].getHeight()+1)*65),turn);
                        myPegs[7].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>220)&&(beadX<255)){
                if((beadY>400)&&(beadY<670)){
                    if(myPegs[8].getHeight()<4){
                        myBeads[turn]=new Bead(215,(670-(myPegs[8].getHeight()+1)*65),turn);
                        myPegs[8].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>425)&&(beadX<460)){
                if((beadY>355)&&(beadY<625)){
                    if(myPegs[9].getHeight()<4){
                        myBeads[turn]=new Bead(420,(625-(myPegs[9].getHeight()+1)*65),turn);
                        myPegs[9].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>635)&&(beadX<670)){
                if((beadY>310)&&(beadY<580)){
                    if(myPegs[10].getHeight()<4){
                        myBeads[turn]=new Bead(630,(580-(myPegs[10].getHeight()+1)*65),turn);
                        myPegs[10].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>875)&&(beadX<910)){
                if((beadY>260)&&(beadY<530)){
                    if(myPegs[11].getHeight()<4){
                        myBeads[turn]=new Bead(870,(530-(myPegs[11].getHeight()+1)*65),turn);
                        myPegs[11].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>300)&&(beadX<335)){
                if((beadY>500)&&(beadY<770)){
                    if(myPegs[12].getHeight()<4){
                        myBeads[turn]=new Bead(295,(770-(myPegs[12].getHeight()+1)*65),turn);
                        myPegs[12].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>525)&&(beadX<560)){
                if((beadY>445)&&(beadY<715)){
                    if(myPegs[13].getHeight()<4){
                        myBeads[turn]=new Bead(520,(715-(myPegs[13].getHeight()+1)*65),turn);
                        myPegs[13].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>750)&&(beadX<785)){
                if((beadY>390)&&(beadY<660)){
                    if(myPegs[14].getHeight()<4){
                        myBeads[turn]=new Bead(745,(660-(myPegs[14].getHeight()+1)*65),turn);
                        myPegs[14].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
            if((beadX>975)&&(beadX<1010)){
                if((beadY>335)&&(beadY<605)){
                    if(myPegs[15].getHeight()<4){
                        myBeads[turn]=new Bead(970,(605-(myPegs[15].getHeight()+1)*65),turn);
                        myPegs[15].addBead(myBeads[turn]);
                        System.out.println("Test");
                        turn++;
                        repaint();
                    }
                    else{
                        System.out.println("Peg full");
                    }
                }
            }
    }
}
