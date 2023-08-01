import java.util.Calendar;

public class Sebastian_Solution {
    private static final int BOARD_SIZE = 8;
    public static void main(String[] args) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        int[] board = new int[BOARD_SIZE];
        int solutions = 0;
        int col = 0;
        int row = 0;
        while (true) {
            if (col == BOARD_SIZE) {
                solutions++;
                displayBoard(board, solutions);
                col--;
                if (col < 0) {
                    break; // All solutions found
                }
                row = board[col] + 1;
            }

            boolean placed = false;
            for (int i = row; i < BOARD_SIZE; i++) {
                if (isSafe(board, i, col)) {
                    board[col] = i;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                board[col] = 0; // Reset the column, backtrack
                col--;
                if (col < 0) {
                    break; // No more solutions
                }
                row = board[col] + 1;
            } else {
                col++;
                row = 0;
            }
        }

        System.out.println("Total solutions: " + solutions);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    private static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row || Math.abs(row - board[i]) == Math.abs(col - i)) {
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(int[] board, int solutionNumber) {
        System.out.println("Solution " + solutionNumber + ":\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[j] == i) {
                    System.out.print("| Q ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }
}