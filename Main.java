package ca.unbc.cpsc.score4;



import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }
        Game game = new Game();
        javax.swing.SwingUtilities.invokeLater(() -> {
            game.startGame();
        });
    }

}
