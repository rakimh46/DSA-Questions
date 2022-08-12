//Minimum Wire Required To Connect All Pcs
class Solution {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class MSTPair implements Comparable<MSTPair> {
        int vtx, pvtx, wt;

        MSTPair(int vtx, int pvtx, int wt) {
            this.vtx = vtx;
            this.pvtx = pvtx;
            this.wt = wt;
        }

        public int compareTo(MSTPair o) {
            return this.wt - o.wt;
        }
    }

    public static void minimumSpan(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<MSTPair> pq = new PriorityQueue<>();
        pq.add(new MSTPair(0, -1, 0));
        while (pq.size() > 0) {
            MSTPair pair = pq.remove();
            if (visited[pair.vtx] == true) {
                continue;
            }
            visited[pair.vtx] = true;
            for (Edge e : graph[pair.vtx]) {
                if (visited[e.nbr] == false) {
                    pq.add(new MSTPair(e.nbr, pair.vtx,e.wt));
                }
            }
        }
    }
}
