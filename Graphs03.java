
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graphs03 {

    public static void main(String[] args) {

    }

    public List<Integer> topologicalSort(int[][] adj) {
        List<Integer> ans = new ArrayList<>();
        int n = adj.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i, visited, adj, ans);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    private List<Integer> dfs(int i, boolean[] visited, int[][] adj, List<Integer> ans) {
        visited[i] = true;
        for (int ele : adj[i]) {
            if (visited[ele] == false) {
                dfs(ele, visited, adj, ans);
            }
            ans.add(i);
        }
        return ans;
    }

}
