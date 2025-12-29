
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graphs04 {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        // boolean[] visited = new boolean[numCourses];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                // visited[i] = true;
            }
        }
        if (q.isEmpty()) {
            return false;
        } else {
            while (!q.isEmpty()) {
                int front = q.remove();
                ans.add(front);
                for (int ele : adj.get(front)) {
                    indegree[ele]--;
                    // if (visited[ele] == false) {
                    if (indegree[ele] == 0) {
                        q.add(ele);
                        // visited[ele] = true;
                        // }
                    }
                }
            }
        }
        return ans.size() == numCourses;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        // boolean[] visited = new boolean[numCourses];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                // visited[i] = true;
            }
        }
        if (q.isEmpty()) {
            return new int[0];
        } else {
            while (!q.isEmpty()) {
                int front = q.remove();
                ans.add(front);
                for (int ele : adj.get(front)) {
                    indegree[ele]--;
                    // if (visited[ele] == false) {
                    if (indegree[ele] == 0) {
                        q.add(ele);
                        // visited[ele] = true;
                        // }
                    }
                }
            }
        }
        int[] result = new int[ans.size()];
        if (ans.size() == numCourses) {
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int ele : graph[i]) {
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int front = q.remove();
            ans.add(front);
            for (int ele : adj.get(front)) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    static boolean ans2;

    public boolean canFinishdfs(int numCourses, int[][] prerequisites) {
        ans2 = true; // true means no cycle detected..
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                dfs(i, adj, visited, path);
                if (ans2 == false) {
                    return false;
                }
            }
        }
        return ans2;
    }

    private void dfs(int i, List<List<Integer>> adj, boolean[] visited, boolean[] path) {
        if (ans2 == false) {
            return;
        }
        visited[i] = true;
        path[i] = true;
        for (int ele : adj.get(i)) {
            if (path[ele] == true) {
                ans2 = false;
                return;
            }
            if (visited[ele] == false) {
                dfs(ele, adj, visited, path);
            }
        }
        path[i] = false;
    }

}
