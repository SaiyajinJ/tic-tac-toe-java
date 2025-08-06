import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
        private Board board;

        @BeforeEach
        void setUp() {
            board = new Board();
        }

        // --- place() ---

        @Test
        void place_validMove_placesMarker() {
            board.place(0, 0, 'X');
            assertFalse(board.isCellEmpty(0, 0));
        }

        @Test
        void place_onTakenCell_throwsException() {
            board.place(0, 0, 'X');
            assertThrows(IllegalStateException.class, () -> board.place(0, 0, 'O'));
        }

        // --- isCellEmpty() ---

        @Test
        void isCellEmpty_emptyCell_returnsTrue() {
            assertTrue(board.isCellEmpty(1, 1));
        }

        @Test
        void isCellEmpty_filledCell_returnsFalse() {
            board.place(1, 1, 'X');
            assertFalse(board.isCellEmpty(1, 1));
        }

        // --- isFull() ---

        @Test
        void isFull_emptyBoard_returnsFalse() {
            assertFalse(board.isFull());
        }

        @Test
        void isFull_filledBoard_returnsTrue() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board.place(i, j, 'X');
                }
            }
            assertTrue(board.isFull());
        }

        // --- clear() ---

        @Test
        void clear_filledBoard_clearsAllCells() {
            board.place(0, 0, 'X');
            board.clear();
            assertTrue(board.isCellEmpty(0, 0));
        }

        @Test
        void clear_onEmptyBoard_doesNothingHarmful() {
            assertDoesNotThrow(() -> board.clear());
        }

        // --- print() ---

        @Test
        void print_doesNotThrow() {
            assertDoesNotThrow(() -> board.print());
        }

        @Test
        void print_afterPlacingMarker_showsOutput() {
            board.place(0, 0, 'O');
            assertDoesNotThrow(() -> board.print());
        }
    }