
import java.util.ArrayList;
import java.util.List;

public class BackTrackingQuestions {

    public static void main(String[] args) {
        // int rows = 3;
        // int cols = 3;
        // boolean[][] isVisited = new boolean[rows][cols];
        // System.out.println(maze(0, 0, rows - 1, cols - 1));
        // printPath(0, 0, rows - 1, cols - 1, "");
        // FourDirectionMazePath(0, 0, rows - 1, cols - 1, "", isVisited);
        // int[][] maze = {
        //     {1, 1, 1},
        //     {1, 1, 1},
        //     {0, 1, 1}
        // };
        // ratInaDeadMaze(0, 0, rows - 1, cols - 1, "", maze);
        // ratInaDeadMazeFourDirection(0, 0, rows - 1, cols - 1, "", maze, isVisited);
        // ratInaDeadMazeFourDirection(0, 0, rows - 1, cols - 1, "", maze);
        // printPermutations("abc", "");
        // printNQueens(4);
        // printNKnights(3);
        maxKnights(4);
    }

    public static int maze(int sr, int sc, int er, int ec) {
        if (sr > er || sc > ec) {
            return 0;
        }
        if (sr == er && sc == ec) {
            return 1;
        }
        int downWays = maze(sr + 1, sc, er, ec);
        int rightWays = maze(sr, sc + 1, er, ec);
        int totalWays = downWays + rightWays;
        return totalWays;
    }

    public static void printPath(int sr, int sc, int er, int ec, String s) {
        if (sr > er || sc > ec) {
            return;
        }
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        printPath(sr + 1, sc, er, ec, s + "D");
        printPath(sr, sc + 1, er, ec, s + "R");
    }

    public static void FourDirectionMazePath(int sr, int sc, int er, int ec, String s, boolean[][] isVisited) {
        if (sr > er || sc > ec || sr < 0 || sc < 0) {
            return;
        }
        if (isVisited[sr][sc] == true) {
            return;
        }
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;
        // Right
        FourDirectionMazePath(sr, sc + 1, er, ec, s + "R", isVisited);
        // Down 
        FourDirectionMazePath(sr + 1, sc, er, ec, s + "D", isVisited);
        // Left
        FourDirectionMazePath(sr, sc - 1, er, ec, s + "L", isVisited);
        // Up
        FourDirectionMazePath(sr - 1, sc, er, ec, s + "U", isVisited);
        isVisited[sr][sc] = false;
    }

    public static void ratInaDeadMaze(int sr, int sc, int er, int ec, String s, int[][] maze) {
        if (sr > er || sc > ec) {
            return;
        }
        if (maze[sr][sc] == 0) {
            return;
        }
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        // Right
        ratInaDeadMaze(sr, sc + 1, er, ec, s + "R", maze);
        // Down
        ratInaDeadMaze(sr + 1, sc, er, ec, s + "D", maze);
    }

    public static void ratInaDeadMazeFourDirection(int sr, int sc, int er, int ec, String s, int[][] maze, boolean[][] isVisited) {
        if (sr > er || sc > ec || sr < 0 || sc < 0) {
            return;
        }
        if (maze[sr][sc] == 0) {
            return;
        }
        if (isVisited[sr][sc] == true) {
            return;
        }
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;
        // Right
        ratInaDeadMazeFourDirection(sr, sc + 1, er, ec, s + "R", maze, isVisited);
        // Down
        ratInaDeadMazeFourDirection(sr + 1, sc, er, ec, s + "D", maze, isVisited);
        // Left
        ratInaDeadMazeFourDirection(sr, sc - 1, er, ec, s + "L", maze, isVisited);
        // Up
        ratInaDeadMazeFourDirection(sr - 1, sc, er, ec, s + "U", maze, isVisited);
        isVisited[sr][sc] = false;
    }

    public static void ratInaDeadMazeFourDirection(int sr, int sc, int er, int ec, String s, int[][] maze) {
        if (sr > er || sc > ec || sr < 0 || sc < 0) {
            return;
        }
        if (maze[sr][sc] == 0) {
            return;
        }
        if (maze[sr][sc] == -1) {
            return;
        }
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        maze[sr][sc] = -1;
        // Right
        ratInaDeadMazeFourDirection(sr, sc + 1, er, ec, s + "R", maze);
        // Down
        ratInaDeadMazeFourDirection(sr + 1, sc, er, ec, s + "D", maze);
        // Left
        ratInaDeadMazeFourDirection(sr, sc - 1, er, ec, s + "L", maze);
        // Up
        ratInaDeadMazeFourDirection(sr - 1, sc, er, ec, s + "U", maze);
        maze[sr][sc] = 1;
    }

    public static void printPermutations(String p, String up) {
        if ("".equals(p)) {
            System.out.println(up);
            return;
        }
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            String left = p.substring(0, i);
            String right = p.substring(i + 1);
            String rem = left + right;
            printPermutations(rem, up + ch);
        }
    }

    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     List<Integer> ds = new ArrayList<>();
    //     boolean[] isValid = new boolean[nums.length];
    //     helper(nums, ds, isValid, ans);
    //     return ans;
    // }
    // private void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
    //     if (ds.size() == nums.length) {
    //         List<Integer> list = new ArrayList<>();
    //         for (int i = 0; i < nums.length; i++) {
    //             list.add(ds.get(i));
    //         }
    //         ans.add(list);
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (isValid[i] == false) {
    //             ds.add(nums[i]);
    //             isValid[i] = true;
    //             helper(nums, ds, isValid, ans);
    //             isValid[i] = false;
    //             ds.remove(ds.size() - 1);
    //         }
    //     }
    // }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void printNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nqueen(board, 0);
    }

    private static void nqueen(char[][] board, int row) {
        int n = board.length;
        if (n == row) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nqueen(board, row + 1);
                board[row][col] = 'X'; // BackTracking
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // Check for row
        int n = board.length;
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check for col
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check for north east
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        // Check for south east
        i = row;
        j = col;
        while (i < n && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }

        // Check for south west
        i = row;
        j = col;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }

        // Check for north west
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nqueen1(board, 0, ans);
        return ans;
    }

    private static void nqueen1(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;
        if (n == row) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    str += board[i][j];
                }
                list.add(str);
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nqueen1(board, row + 1, ans);
                board[row][col] = '.'; // BackTracking
            }
        }
    }

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int size = grid.length * grid.length;
        int row = 0;
        int col = 0;
        for (int index = 1; index < size; index++) {

            if (grid[0][0] != 0) {
                return false;
            } else {

                // Up left
                int i = row;
                int j = col;
                i -= 2;
                j -= 1;
                if (i >= 0 && j >= 0) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Up right
                i = row;
                j = col;
                i -= 2;
                j += 1;
                if (i >= 0 && j < n) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Left Up
                i = row;
                j = col;
                i -= 1;
                j -= 2;
                if (i >= 0 && j >= 0) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Right up
                i = row;
                j = col;
                i -= 1;
                j += 2;
                if (i >= 0 && j < n) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Left down
                i = row;
                j = col;
                i += 1;
                j -= 2;
                if (j >= 0 && i < n) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Right down
                i = row;
                j = col;
                i += 1;
                j += 2;
                if (i < n && j < n) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Down left
                i = row;
                j = col;
                i += 2;
                j -= 1;
                if (j >= 0 && i < n) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }

                // Down right
                i = row;
                j = col;
                i += 2;
                j += 1;
                if (i < n && j < n) {
                    if (grid[i][j] == index) {
                        row = i;
                        col = j;
                        continue;
                    }
                }
            }
            return false;
        }
        return true;
    }

    static int maximum = -1;

    // static int number = 5;
    public static void printNKnights(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        nknight(board, 0, 0, 0);
    }

    public static void nknight(char[][] board, int row, int col, int num) {
        int n = board.length;
        if (n == row) {
            // if (num == number) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            // }
            return;
        }
        if (isSafeKnight(board, row, col)) {
            board[row][col] = 'K';
            if (col != n - 1) {
                nknight(board, row, col + 1, num + 1);
            } else {
                nknight(board, row + 1, 0, num + 1);
            }
            board[row][col] = 'x'; // BackTracking
        }
        if (col != n - 1) {
            nknight(board, row, col + 1, num);
        } else {
            nknight(board, row + 1, 0, num);
        }
    }

    public static boolean isSafeKnight(char[][] board, int row, int col) {
        int n = board.length;
        int i, j;
        // 2 Up 1 Right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && board[i][j] == 'K') {
            return false;
        }
        // 2 Up 1 Left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && board[i][j] == 'K') {
            return false;
        }
        // 2 Down 1 Right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && board[i][j] == 'K') {
            return false;
        }
        // 2 Down 1 Left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && board[i][j] == 'K') {
            return false;
        }
        // 2 Right 1 Up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && board[i][j] == 'K') {
            return false;
        }
        // 2 Right 1 Down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && board[i][j] == 'K') {
            return false;
        }
        // 2 Left 1 Up
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && board[i][j] == 'K') {
            return false;
        }
        // 2 Left 1 Down
        i = row + 1;
        j = col - 2;
        // if (i < n && j >= 0 && board[i][j] == 'K') {
        //     return false;
        // }
        // return true;
        return !(i < n && j >= 0 && board[i][j] == 'K');
    }

    public static void maxKnights(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        maxnknight(board, 0, 0, 0);
        System.out.println(maximum);
    }

    public static void maxnknight(char[][] board, int row, int col, int num) {
        int n = board.length;
        if (n == row) {
            maximum = Math.max(num, maximum);
            return;
        }
        if (isSafeKnight(board, row, col)) {
            board[row][col] = 'K';
            if (col != n - 1) {
                maxnknight(board, row, col + 1, num + 1);
            } else {
                maxnknight(board, row + 1, 0, num + 1);
            }
            board[row][col] = 'x'; // BackTracking
        }
        if (col != n - 1) {
            maxnknight(board, row, col + 1, num);
        } else {
            maxnknight(board, row + 1, 0, num);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char num = board[i][j];
                board[i][j] = '.';
                if (isValid(board, i, j, num) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check for row 
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check for col 
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 grid
        int rowindex = (row / 3) * 3;
        int colindex = (col / 3) * 3;
        for (int i = rowindex; i < rowindex + 3; i++) {
            for (int j = colindex; j < colindex + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // public void solveSudoku(char[][] board) {
    //     char[][] grid = new char[9][9];
    //     solve(board, 0, 0, grid);
    //     for (int i = 0; i < 9; i++) {
    //         System.arraycopy(grid[i], 0, board[i], 0, 9);
    //     }
    // }
    // private void solve(char[][] board, int row, int col, char[][] grid) {
    //     if (row == 9) {
    //         for (int i = 0; i < 9; i++) {
    //             System.arraycopy(board[i], 0, grid[i], 0, 9);
    //         }
    //         return;
    //     }
    //     if (board[row][col] != '.') {
    //         if (col != 8) {
    //             solve(board, row, col + 1, grid);
    //         } else {
    //             solve(board, row + 1, 0, grid);
    //         }
    //     } else { // board[row][col] != '.'
    //         for (char ch = '1'; ch <= '9'; ch++) {
    //             if (isValid(board, row, col, ch)) {
    //                 board[row][col] = ch;
    //                 if (col != 8) {
    //                     solve(board, row, col + 1, grid);
    //                 } else {
    //                     solve(board, row + 1, 0, grid);
    //                 }
    //                 board[row][col] = '.';
    //             }
    //         }
    //     }
    // }
    static int check = 0;

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        check = 0;
    }

    private void solve(char[][] board, int row, int col) {
        if (row == 9) {
            check = 1;
            return;
        }
        if (board[row][col] != '.') {
            if (col != 8) {
                solve(board, row, col + 1);
            } else {
                solve(board, row + 1, 0);
            }
        } else { // board[row][col] != '.'
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col != 8) {
                        solve(board, row, col + 1);
                    } else {
                        solve(board, row + 1, 0);
                    }
                    if (check == 1) {
                        return;
                    }
                    board[row][col] = '.'; // Backtracking
                }
            }
        }
    }

}
