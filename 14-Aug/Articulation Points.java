https://practice.geeksforgeeks.org/problems/doctor-strange2206/1

class Complete{
    
    // Function for finding maximum and value pair
    static int[] par;
    static int[] dis;
    static int[] low;
    static boolean[] ap;
    static boolean[] vis;
    static int time;
    static int count;
    static ArrayList<ArrayList<Integer>> graph;
    public static int doctorStrange (int n, int k, int g[][]) {
        //Complete the function
    graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:g){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        par=new int[n+1];
        dis=new int[n+1];
        low=new int[n+1];
        ap=new boolean[n+1];
        vis=new boolean[n+1];
        time=1;
        count=0;

        dfs(1);

        int ans=0;
        for(boolean e:ap){
            if(e) ans++;
        }
        return ans;
    }

    public static void dfs(int u){
        dis[u]=time;
        low[u]=time;
        vis[u]=true;
        time++;

        for(int v:graph.get(u)){
            if(par[u]==v) continue;
            else if(vis[v]){
                low[u]=Math.min(low[u],dis[v]);
            }else{
                par[v]=u;
                dfs(v);
                if(par[u]==0){
                    count++;
                    if(count>=2){
                        ap[u]=true;
                    }
                }else if(low[v]>=dis[u]){
                    ap[u]=true;
                }

                low[u]=Math.min(low[u],low[v]);
            }
        }
    }

}
