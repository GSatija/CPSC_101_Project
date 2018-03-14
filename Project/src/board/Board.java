package board;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board {


    BufferedImage image;

    public Board() {

    }

    public void draw(Graphics g) throws IOException {

        Graphics2D g2 = (Graphics2D) g;
        image = ImageIO.read(new File("images\\emptyboard.png"));
        g2.drawImage(image, 30, 300, null);

    }
}
