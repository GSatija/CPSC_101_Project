package ca.unbc.cpsc.score4;



import ca.unbc.cpsc.score4.exceptions.PlayerException;
import ca.unbc.cpsc.score4.interfaces.Location;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import java.util.Random;

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
    Random ran = new Random();
    computerPlayer playerJarvis=new computerPlayer();
    ca.unbc.cpsc.score4.interfaces.Location location = new ca.unbc.cpsc.score4.interfaces.Location() {
        @Override
        public int getRow() {
            return ran.nextInt(3);
        }

        @Override
        public int getColumn() {
            return ran.nextInt(3);
        }
    };

    Line line = new Line();
    boolean noClick = true;
    boolean click = false;

    Bead[] myBeads = new Bead[64];

    private int turn = 0;

    private int beadX;
    private int beadY;

    String lastMove;

    Board board = new Board();


    int j = location.getRow() * 4 + location.getColumn();
    int k;

    private boolean gameWon = false;

    public PaintComponent(Player player1, Player player2) {
        addMouseListener(this);
        p1 = player1;
        p2 = player2;
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
            for (Peg myPeg : myPegs) {
                myPeg.draw(g2);
            }
        } catch (IOException ex) {
            Logger.getLogger(PaintComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        beadX = e.getX();
        beadY = e.getY();
        findPeg(e.getX(), e.getY());
        System.out.println(gameWon);

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

    public void resetClick() {
        noClick = true;
    }

    public boolean beadPlaced() {
        return !noClick;
    }

    public boolean gameWon() {
        return gameWon;
    }

    public String getLastMove() {
        return lastMove;
    }

    public void restart() {
        turn = 0;
        gameWon = false;
    }

    public void getJarvis() throws PlayerException {
        if (gameWon == false && j < 16 && myPegs[j].getHeight() < 4) {
            aiMove();
        } else {
            j++;
            aiMove();
        }
    }

    public void findPeg(int x, int y) {
        if (!click) {
            beadX = x;
            beadY = y;
            click = true;
        }
        repaint();
        if (noClick == true && gameWon == false) {
            if (((beadX < 85) && (beadX > 50)) && ((beadY < 470) && (beadY > 195))) {
                k = 0;
            } else if ((beadX < 290) && (beadX > 255) && ((beadY > 155) && (beadY < 425))) {
                k = 1;
            } else if ((beadX < 495) && (beadX > 460) && ((beadY > 110) && (beadY < 385))) {
                k = 2;
            } else if ((beadX < 705) && (beadX > 670) && ((beadY > 70) && (beadY < 340))) {
                k = 3;
            } else if ((beadX < 170) && (beadX > 135) && ((beadY > 300) && (beadY < 570))) {
                k = 4;
            } else if ((beadX > 340) && (beadX < 375) && ((beadY > 255) && (beadY < 525))) {
                k = 5;
            } else if ((beadX > 545) && (beadX < 580) && ((beadY > 210) && (beadY < 435))) {
                k = 6;
            } else if ((beadX > 770) && (beadX < 805) && ((beadY > 160) && (beadY < 380))) {
                k = 7;
            } else if ((beadX > 220) && (beadX < 255) && ((beadY > 400) && (beadY < 670))) {
                k = 8;
            } else if ((beadX > 425) && (beadX < 460) && ((beadY > 355) && (beadY < 625))) {
                k = 9;
            } else if ((beadX > 635) && (beadX < 670) && ((beadY > 310) && (beadY < 580))) {
                k = 10;
            } else if ((beadX > 875) && (beadX < 910) && ((beadY > 260) && (beadY < 530))) {
                k = 11;
            } else if ((beadX > 300) && (beadX < 335) && ((beadY > 500) && (beadY < 770))) {
                k = 12;
            } else if ((beadX > 525) && (beadX < 560) && ((beadY > 445) && (beadY < 715))) {
                k = 13;
            } else if ((beadX > 750) && (beadX < 785) && ((beadY > 390) && (beadY < 660))) {
                k = 14;
            } else {
                k = 15;
            }

            if (myPegs[k].getHeight() < 4) {
                myBeads[turn] = new Bead(40 + myPegs[k].getLocation()[0], (405 + myPegs[k].getLocation()[1] - (myPegs[k].getHeight() + 1) * 65), turn);
                myPegs[k].addBead(myBeads[turn]);
                turn++;
                noClick = false;
                repaint();
                boolean value = line.check(myPegs[k], k, myPegs);
                if (value == true) {
                    System.err.println("yippee");
                    JOptionPane.showMessageDialog(null, "Player " + myBeads[turn - 1].c + " won");
                    gameWon = true;
                    System.out.println(gameWon);
                }
                lastMove = myPegs[k].getName();

            }
        }

    }

    public void aiMove() throws PlayerException {


        ca.unbc.cpsc.score4.interfaces.Location location = playerJarvis.requestMoveLocation();


        int pegNumber=location.getRow()*4 + location.getColumn();




        myBeads[turn] = new Bead(42 + myPegs[j].getLocation()[0], (407 + myPegs[j].getLocation()[1] - (myPegs[j].getHeight() + 1) * 65), turn);
        myPegs[j].addBead(myBeads[turn]);
        turn++;
        noClick = false;
        repaint();
        boolean value = line.check(myPegs[j], j, myPegs);

        j = pegNumber;
        lastMove = myPegs[j].getName();
        if (value == true) {
            System.err.println(" yippee");
            JOptionPane.showMessageDialog(null, "Player " + myBeads[turn - 1].c + " won");
            gameWon = true;
            System.out.println(gameWon);
        }
    }


//    public void newGame() {
//        int i = 0;
//        while (i < 16) {
//            myPegs[i].clearPeg();
//            i++;
//        }
//        restart();
//        resetClick();
//        repaint();
//        j = ran.nextInt(15);
//    }

//
//    // Checking methods for the AI player so that the opponent cannot win.
//
//    public Location checkHeightWise() {
//
//        Location localResult;
//
//        int i = 0;
//        char colourChar;
//
//        while (i < 16) {
//
//            colourChar = computerPlayer.board[i][0];
//
//            if (colourChar == computerPlayer.board[i][1] && colourChar == computerPlayer.board[i][2]) {
//
//                int finalI = i;
//                localResult = new Location() {
//                    @Override
//                    public int getRow() {
//                        return finalI;
//                    }
//
//                    @Override
//                    public int getColumn() {
//                        return 3;
//                    }
//                };
//
//                return localResult;
//
//            }
//            i++;
//
//        }
//        return null;
//    }
//
//
//    public Location checkRowWise() {
//
//        Location localResult;
//
//        int i = 0;
//        char colourChar;
//
//        while (i < 13) {
//
//            int height = 0, pegNumber = 0;
//
//            int count = 0;
//
//            while (height < 4) {
//
//                int row1 = 0, row2 = 0, row3 = 0;
//                colourChar = 'z';    // just initializing
//
//                if (computerPlayer.board[i][height] != '\u0000') {
//                    colourChar = computerPlayer.board[i][height];
//                    row1 = i + 1;
//                    row2 = row1 + 1;
//                    row3 = row2 + 1;
//
//                } else if (computerPlayer.board[i + 1][height] != '\u0000') {
//                    colourChar = computerPlayer.board[i + 1][height];
//                    row1 = i;
//                    row2 = row1 + 1;
//                    row3 = row2 + 1;
//                }
//
//                if (colourChar == computerPlayer.board[row1][height]) {
//                    ++count;
//                } else {
//                    pegNumber = row1;
//                }
//
//                if (colourChar == computerPlayer.board[row2][height]) {
//                    ++count;
//                } else {
//                    pegNumber = row2;
//                }
//
//                if (colourChar == computerPlayer.board[row3][height]) {
//                    ++count;
//                } else {
//                    pegNumber = row3;
//                }
//
//                if (count == 1) {
//
//
//                    int finalHeight = height;
//                    int finalPegNumber = pegNumber;
//                    localResult = new Location() {
//                        @Override
//                        public int getRow() {
//                            return finalPegNumber;
//                        }
//
//                        @Override
//                        public int getColumn() {
//                            return finalHeight;
//                        }
//                    };
//
//                    return localResult;
//                }
//                height++;
//            }
//            i += 4;
//
//        }
//        return null;
//
//    }
//
//
//    public Location checkColumnWise() {
//
//        Location localResult;
//
//        int i = 0;
//        char colourChar;
//
//        while (i < 4) {
//
//            int height = 0, pegNumber = 0;
//
//            int count = 0;
//
//            while (height < 4) {
//
//                int column1 = 0, column2 = 0, column3 = 0;
//                colourChar = 'z';    // just initializing
//
//                if (computerPlayer.board[i][height] != '\u0000') {
//                    colourChar = computerPlayer.board[i][height];
//                    column1 = i + 4;
//                    column2 = i + 8;
//                    column3 = i + 12;
//
//                } else if (computerPlayer.board[i + 1][height] != '\u0000') {
//                    colourChar = computerPlayer.board[i + 1][height];
//                    column1 = i;
//                    column2 = i + 8;
//                    column3 = i + 12;
//                }
//
//                if (colourChar == computerPlayer.board[column1][height]) {
//                    ++count;
//                } else {
//                    pegNumber = column1;
//                }
//
//                if (colourChar == computerPlayer.board[column2][height]) {
//                    ++count;
//                } else {
//                    pegNumber = column2;
//                }
//
//                if (colourChar == computerPlayer.board[column3][height]) {
//                    ++count;
//                } else {
//                    pegNumber = column3;
//                }
//
//                if (count == 1) {
//
//
//                    int finalHeight = height;
//                    int finalPegNumber = pegNumber;
//                    localResult = new Location() {
//                        @Override
//                        public int getRow() {
//                            return finalPegNumber;
//                        }
//
//                        @Override
//                        public int getColumn() {
//                            return finalHeight;
//                        }
//                    };
//
//                    return localResult;
//                }
//                height++;
//            }
//            i++;
//
//        }
//        return null;
//
//    }
}