class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color=new int[n];
        return coloring(graph,color,m,n,0);
    }
    
    public boolean coloring(boolean graph[][],int[] color, int m, int n,int node){
        if(node==n){
            return true;
        }
        
        for(int i=1;i<=m;i++){
            if(issafe(graph,color,i,n,node)){
                color[node]=i;
                if(coloring(graph,color,m,n,node+1)){
                    return true;
                }
                color[node]=0;
            }
        }
        return false;
    }
    
    public boolean issafe(boolean graph[][],int[] color, int cn, int n,int node){
        for(int i=0;i<n;i++){
            if(graph[node][i]==true && color[i]==cn){
                return false;
            }
        }
        return true;
    }
}
