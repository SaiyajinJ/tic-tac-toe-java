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
            board.print();

            if (hasWinner()) {
                switchCurrentPlayer(); // zurück zum letzten Spieler (der gewonnen hat)
                System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
            } else {
                System.out.println("Unentschieden!");
            }
        }

        board.print();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] g = board.getCells();
        char m = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if (g[i][0] == m && g[i][1] == m && g[i][2] == m) return true; // horizontal
            if (g[0][i] == m && g[1][i] == m && g[2][i] == m) return true; // vertikal
        }
        return (g[0][0] == m && g[1][1] == m && g[2][2] == m) || // diagonal
                (g[0][2] == m && g[1][1] == m && g[2][0] == m);   // anti-diagonal
    }
}
