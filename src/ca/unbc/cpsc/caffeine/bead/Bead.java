package ca.unbc.cpsc.caffeine.bead;

import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bead {

    int myX = 0;
    int myY = 0;
    int myTurn;
    BufferedImage bead;
    public Color c;

    public Bead(int x, int y, int myTurn) {
        myX = x;
        myY = y;
        this.myTurn = myTurn;
        if (myTurn % 2 == 0) {
            c = white;
        } else {
            c = black;
        }
    }

    public void drawWhite(Graphics g, int x, int y) throws IOException {
        Graphics2D g2 = (Graphics2D) g;
        myX = x;
        myY = y;
        bead = ImageIO.read(new File("images\\beadWhite.png"));
        g2.drawImage(bead, myX - 20, myY - 20, null);
    }

    public void drawBlack(Graphics g) throws IOException {
        Graphics2D g2 = (Graphics2D) g;
        bead = ImageIO.read(new File("images\\beadBlack.png"));
        g2.drawImage(bead, myX - 20, myY - 20, null);

    }

    public void draw(Graphics g) throws IOException {
        Graphics2D g2 = (Graphics2D) g;
        if ((myTurn % 2) == 0) {
            bead = ImageIO.read(new File("images\\beadWhite.png"));
            g2.drawImage(bead, myX - 17, myY - 17, null);
        } else {
            bead = ImageIO.read(new File("images\\beadBlack.png"));
            g2.drawImage(bead, myX - 17, myY - 17, null);
        }
    }

    public Color getColour() {
        Color color = c;
        System.out.println(color.getRed() + " " + color.getBlue() + " " + color.getGreen() + " " + white.getRed() + " " + white.getGreen() + " " + white.getBlue());
        return c;
    }

    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public boolean compareTo(Color c2) {

        return c.getRGB() == c2.getRGB();
    }

}

/*

String colour;

bead class getColour()
{
return colour;
}



(in drawWHite)
{
colour = white;
}

vica versa for bl
 */
