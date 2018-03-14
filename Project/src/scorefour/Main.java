package scorefour;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        javax.swing.SwingUtilities.invokeLater(() -> {
            game.startGame();
        });
    }

}
