
import java.util.ArrayList;

public class Maze {

    public static void main(String[] args) {
        System.out.println(count(3, 3));
        path("", 3, 3);
        System.out.println(path1("", 3, 3));
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println(path2("", 3, 3, list2));
        System.out.println(path3("", 3, 3));
        pathDiagonal("", 3, 3);
        System.out.println(pathDiagonal1("", 3, 3));
        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };
        mazeObstacle("", maze, 0, 0);
    }

    static int count(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int left = count(row - 1, col);
        int right = count(row, col - 1);
        return left + right;
    }

    static void path(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }
        if (row > 1) {
            path(p + "D", row - 1, col);
        }
        if (col > 1) {
            path(p + "R", row, col - 1);
        }
    }

    static ArrayList<String> list = new ArrayList<>();

    static ArrayList<String> path1(String p, int row, int col) {
        if (row == 1 && col == 1) {
            list.add(p);
            return list;
        }
        if (row > 1) {
            path1(p + "D", row - 1, col);
        }
        if (col > 1) {
            path1(p + "R", row, col - 1);
        }
        return list;
    }

    static ArrayList<String> path2(String p, int row, int col, ArrayList<String> list2) {
        if (row == 1 && col == 1) {
            list2.add(p);
            return list2;
        }
        if (row > 1) {
            path2(p + "D", row - 1, col, list2);
        }
        if (col > 1) {
            path2(p + "R", row, col - 1, list2);
        }
        return list2;
    }

    static ArrayList<String> path3(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list3 = new ArrayList<>();
            list3.add(p);
            return list3;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(path3(p + "D", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(path3(p + "R", row, col - 1));
        }
        return ans;
    }

    static void pathDiagonal(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }
        if (row > 1) {
            pathDiagonal(p + "D", row - 1, col);
        }
        if (row > 1 && col > 1) {
            pathDiagonal(p + "A", row - 1, col - 1);
        }
        if (col > 1) {
            pathDiagonal(p + "R", row, col - 1);
        }
    }

    static ArrayList<String> pathDiagonal1(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list4 = new ArrayList<>();
            list4.add(p);
            return list4;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(pathDiagonal1(p + "D", row - 1, col));
        }
        if (row > 1 && col > 1) {
            ans.addAll(pathDiagonal1(p + "A", row - 1, col - 1));
        }
        if (col > 1) {
            ans.addAll(pathDiagonal1(p + "R", row, col - 1));
        }
        return ans;
    }

    static void mazeObstacle(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (maze[row][col] == false) {
            return;
        }
        if (row < maze.length - 1) {
            mazeObstacle(p + "D", maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            mazeObstacle(p + "R", maze, row, col + 1);
        }
    }
}
