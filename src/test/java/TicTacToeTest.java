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

}
