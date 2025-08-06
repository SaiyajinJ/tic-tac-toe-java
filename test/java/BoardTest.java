import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
        private Board board;

        @BeforeEach
        void setUp() {
            board = new Board();
        }

        //Test für place() – positiv
        @Test
        void place_validPosition_setsMarker() {
            board.place(1, 1, 'X');
            assertFalse(board.isCellEmpty(1, 1));
        }

        //Test für place() – negativ: belegtes Feld
        @Test
        void place_occupiedPosition_throwsException() {
            board.place(0, 0, 'X');
            assertThrows(IllegalStateException.class, () -> board.place(0, 0, 'O'));
        }

        //Test für isCellEmpty() – positiv
        @Test
        void isCellEmpty_emptyCell_returnsTrue() {
            assertTrue(board.isCellEmpty(2, 2));
        }

        //Test für isCellEmpty() – negativ: belegtes Feld
        @Test
        void isCellEmpty_filledCell_returnsFalse() {
            board.place(1, 2, 'X');
            assertFalse(board.isCellEmpty(1, 2));
        }

        // Test für isFull() – positiv
        @Test
        void isFull_allCellsFilled_returnsTrue() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board.place(i, j, 'X');
                }
            }
            assertTrue(board.isFull());
        }

        //Test für isFull() – negativ
        @Test
        void isFull_someCellsEmpty_returnsFalse() {
            board.place(0, 0, 'X');
            assertFalse(board.isFull());
        }

        // Test für clear() – positiv
        @Test
        void clear_afterFilling_boardIsEmpty() {
            board.place(0, 0, 'O');
            board.clear();
            assertTrue(board.isCellEmpty(0, 0));
        }

        //Test für clear() – negativ (Sicherheit)
        @Test
        void clear_allCellsResetToEmpty() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board.place(i, j, 'X');
                }
            }
            board.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    assertTrue(board.isCellEmpty(i, j));
                }
            }
        }

        // Test für print() – nur Aufruf (visuelle Methode)
        @Test
        void print_doesNotThrowException() {
            assertDoesNotThrow(() -> board.print());
        }

        //Test für print() – sicherstellen, dass leer bleibt nach clear
        @Test
        void print_afterClear_boardIsEmptyVisually() {
            board.clear();
            // hier wird nur geprüft, dass kein Fehler passiert
            assertDoesNotThrow(() -> board.print());
        }
    }