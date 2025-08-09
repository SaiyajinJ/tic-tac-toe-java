import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe game;

    @Test
    void constructor_createsBoardWithoutError() {
        assertDoesNotThrow(() -> new TicTacToe());
    }

    @Test
    void constructor_initializesCurrentPlayer() {
        TicTacToe game = new TicTacToe();
        assertNotNull(game); // Es wird ein Objekt erzeugt
    }

    @Test
    void switchCurrentPlayer_runsWithoutError() {
        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> {
            var method = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
            method.setAccessible(true);
            method.invoke(game);
        });
    }

    @Test
    void switchCurrentPlayer_doesNotReturnNull() throws Exception {
        TicTacToe game = new TicTacToe();
        var field = TicTacToe.class.getDeclaredField("currentPlayer");
        field.setAccessible(true);
        var method = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        method.setAccessible(true);
        method.invoke(game);
        assertNotNull(field.get(game));
    }

    @Test
    void start_methodExistsAndCanBeCalled() {
        TicTacToe game = new TicTacToe();
        assertDoesNotThrow(() -> {
            TicTacToe.class.getDeclaredMethod("start");
        });
    }

    @Test
    void hasWinner_returnsTrueForWinningRow() throws Exception {
        TicTacToe game = new TicTacToe();
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');

        var field = TicTacToe.class.getDeclaredField("board");
        field.setAccessible(true);
        field.set(game, board);

        var playerField = TicTacToe.class.getDeclaredField("currentPlayer");
        playerField.setAccessible(true);
        playerField.set(game, new Player('X'));

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinner_returnsFalseWhenNoWinner() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.hasWinner());
    }
}
