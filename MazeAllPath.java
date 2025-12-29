
import java.util.Arrays;

public class MazeAllPath {

    public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        allpaths("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        allpathsprint("", maze, 0, 0, path, 1);
    }

    static void allpaths(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (maze[row][col] == false) {
            return;
        }
        // i am considering this block in my path
        maze[row][col] = false;
        if (row < maze.length - 1) {
            allpaths(p + "D", maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            allpaths(p + "R", maze, row, col + 1);
        }
        if (row > 0) {
            allpaths(p + "U", maze, row - 1, col);
        }
        if (col > 0) {
            allpaths(p + "L", maze, row, col - 1);
        }
        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[row][col] = true;
    }

    static void allpathsprint(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (maze[row][col] == false) {
            return;
        }
        path[row][col] = step;
        maze[row][col] = false;
        if (row < maze.length - 1) {
            allpathsprint(p + "D", maze, row + 1, col, path, step + 1);
        }
        if (col < maze[0].length - 1) {
            allpathsprint(p + "R", maze, row, col + 1, path, step + 1);
        }
        if (row > 0) {
            allpathsprint(p + "U", maze, row - 1, col, path, step + 1);
        }
        if (col > 0) {
            allpathsprint(p + "L", maze, row, col - 1, path, step + 1);
        }
        maze[row][col] = true;
        path[row][col] = 0;
    }

}
