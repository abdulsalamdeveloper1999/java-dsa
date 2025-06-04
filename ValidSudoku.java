import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {

        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }

        };

        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        Set sudoku = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') {
                    if (!sudoku.add(num + " in a row " + row)
                            || !sudoku.add(num + " in a col " + col)
                            || !sudoku.add(num + " in a block " + row / 3 + " - " + col / 3)) {
                        return false;
                    }
                }

            }
        }

        return true;

    }
}

// 36. Valid Sudoku
// Medium
// Topics
// premium lock icon
// Companies
// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
// validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
// without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily
// solvable.
// Only the filled cells need to be validated according to the mentioned rules.