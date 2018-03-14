package bead;

import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Player.Player;

public class Bead {

    int myX = 0;
    int myY = 0;
    int myTurn;
    boolean draw;
    BufferedImage bead;
    Color c;

    public Bead(int x,int y,int myTurn,Player player1,Player player2) {
        myX = x;
        myY = y;
        this.myTurn=myTurn;
        if(myTurn%2==0){
            draw=true;
            c=player1.getColour();
        }else{
            draw=false;
            c=player2.getColour();
        }
    }

    /*public void drawWhite(Graphics g,int x,int y) throws IOException {
        Graphics2D g2 = (Graphics2D) g;
        myX=x;
        myY=y;
        bead = ImageIO.read(new File("images\\beadWhite.png"));
        g2.drawImage(bead, myX - 20, myY - 20, null);
    }

    public void drawBlack(Graphics g) throws IOException {
        Graphics2D g2 = (Graphics2D) g;
        bead = ImageIO.read(new File("images\\beadBlack.png"));
        g2.drawImage(bead, myX - 20, myY - 20, null);
        
    }*/
    public void draw(Graphics g)throws IOException{
        Graphics2D g2= (Graphics2D) g;
        if(draw){
            bead = ImageIO.read(new File("images\\beadWhite.png"));
            g2.drawImage(bead,myX-20,myY-20,null);
        }
        else{
            bead = ImageIO.read(new File("images\\beadBlack.png"));
            g2.drawImage(bead, myX - 20, myY - 20, null);
        }
    
    }   



 public Color getColour()
{
    Color color=c;
System.out.println(color.getRed()+ " " +color.getBlue()+ " "+color.getGreen()+ " "+white.getRed()+ " "+white.getGreen()+ " "+white.getBlue());
return c;
}

    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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