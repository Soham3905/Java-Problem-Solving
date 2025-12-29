
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // for (int row = 0; row < board.length; row++) {
        //     for (int col = 0; col < board[row].length; col++) {
        //         board[row][col] = ' ';
        //     }
        // }
        // Enhanced for loop...
        for (char[] board1 : board) {
            for (int col = 0; col < board1.length; col++) {
                board1[col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + " enter : ");
            int row = input.nextInt();
            int col = input.nextInt();
            System.out.println();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has Won!!");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid Move. Try Again!");
            }
        }
        printBoard(board);
    }

    static void printBoard(char[][] board) {
        for (char[] board1 : board) {
            for (int col = 0; col < board1.length; col++) {
                System.out.print(board1[col] + " | ");
            }
            System.out.println();
        }
    }

    static boolean haveWon(char[][] board, char player) {
        // row
        for (char[] board1 : board) {
            if (board1[0] == player && board1[1] == player && board1[2] == player) {
                return true;
            }
        }
        // col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

}
