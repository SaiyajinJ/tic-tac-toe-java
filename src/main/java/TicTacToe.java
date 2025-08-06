import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isFull()) {
            board.print();  // 🔹 US02 erfüllt: Anzeige des Spielstands

            System.out.println("Spieler " + currentPlayer.getMarker() + ", gib Zeile (0-2): ");
            int row = scanner.nextInt();
            System.out.println("und Spalte (0-2): ");
            int col = scanner.nextInt();

            try {
                board.place(row, col, currentPlayer.getMarker());
                switchCurrentPlayer();
            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }

        board.print();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return false; // Noch nicht implementiert – gehört zu US03
    }
}
