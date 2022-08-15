https://leetcode.com/problems/critical-connections-in-a-network/

Articulation Bridge topic

class Solution {
    static int[] dis;
    static int[] low;
    static int[] par;
    static boolean[] vis;
    static List<List<Integer>> ans;
    static int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> list : connections) {
            int u = list.get(0);
            int v = list.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dis = new int[n];
        low = new int[n];
        par = new int[n];
        vis = new boolean[n];
        ans = new ArrayList<>();
        time = 1;

        dfs(0, graph);

        return ans;
    }

    public static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        dis[u] = low[u] = time;
        vis[u] = true;
        time++;
        for (Integer v : graph.get(u)) {
            if (par[u] == v) {
                continue;
            } else if (vis[v] == true) {
                low[u] = Math.min(low[u], dis[v]);
            } else {
                par[v] = u;
                dfs(v, graph);
                if (low[v] > dis[u]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }

}
