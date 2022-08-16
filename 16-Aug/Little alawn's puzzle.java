https://codeforces.com/problemset/problem/1534/C
https://chowdera.com/2022/03/202203272312512816.html

// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(
				new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }

		long nextLong() { return Long.parseLong(next()); }

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try {
				if(st.hasMoreTokens()){
					str = st.nextToken("\n");
				}
				else{
					str = br.readLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args)
	{
		FastReader s = new FastReader();
		int t = s.nextInt();
		while (t-- > 0) {
		    int n = s.nextInt();
		    int[] arr1=new int[n];
		    for(int i=0;i<n;i++){
		        arr1[i]=s.nextInt();
		    }
		    int[] arr2=new int[n];
		    for(int i=0;i<n;i++){
		        arr2[i]=s.nextInt();
		    }
		    long count=slove(arr1,arr2);
		    System.out.println(quickpow(2,count));
		}
	}
	static long mod1=1000000007;
	
	static long quickpow(long base,long pow){
        long ans=1;
    
        while(pow-->0)
        {
            ans=(ans*base)%mod1;
        }
        return ans%mod1;
    }
	
	public static long slove(int[] arr1,int[] arr2){
	    ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
	    int n=arr1.length;
	    for(int i=0;i<=n;i++){
	        graph.add(new ArrayList<>());
	    }
	    for(int i=0;i<n;i++){
	        graph.get(arr1[i]).add(arr2[i]);
	        graph.get(arr2[i]).add(arr1[i]);
	    }
	    
	    boolean[]vis=new boolean[n+1];
	    long count=0;
	    for(int i=1;i<=n;i++){
	        if(!vis[i]){
	            count++;
	            dfs(graph,i,vis);
	        } 
	    }
	    return count;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph,int node,boolean[] vis){
	    vis[node]=true;
	    for(int nbr:graph.get(node)){
	        if(!vis[nbr]){
	            dfs(graph,nbr,vis);
	        }
	    }
	}
}
