By DSU wth sorting edge
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/optimize-water-distribution-official/ojquestion
Time Complexity: O(ElogE) or O(ElogV)

import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);

    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }
  
  static class Edge{
      int src;
      int nbr;
      int wt;
      Edge(int s,int n,int w){
          src=s;
          nbr=n;
          wt=w;
      }
  } 
  
  public static int find(int x){
      if(x==par[x]) return x;
      
      return par[x]=find(par[x]);
  }
  
  public static boolean union(int x,int y){
      int px=find(x);
      int py=find(y);
      if(px==py) return false;
      else{
          par[py]=px;
          return true;
      }
  }
  
  static int[] par;
  static int[] rank;
  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
      
      List<Edge> list=new ArrayList<Edge>();
      
      for(int i=0;i<wells.length;i++){
          list.add(new Edge(0,i+1,wells[i]));
      }
      
      for(int[]p:pipes ){
          list.add(new Edge(p[0],p[1],p[2]));
      }
      
      Collections.sort(list, new Comparator<Edge>(){
          @Override
          public int compare(Edge q,Edge w){
              return q.wt-w.wt;
          }
      });
      
      par =new int[n+1];
      
      for(int i=0;i<=n;i++) par[i]=i;
      
      int cost=0;
      for(Edge e: list){
          int s=e.src;
          int nb=e.nbr;
          int w=e.wt;
          if(union(s,nb)){
              cost+=w;
          }
      }
      return cost;
  }
}
