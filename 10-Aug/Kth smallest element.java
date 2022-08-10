class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        countsort(arr);
        return arr[k-1];
    } 
    
    public static void countsort(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int v:arr){
            max=Math.max(max,v);
        }
        
        int[] fq=new int[max+1];
        for(int v: arr){
            fq[v]++;
        }
        
        int idx=0;
        for(int i=0;i<fq.length;i++){
            int c=fq[i];
            while(c-->0){
                arr[idx++]=i;
            }
        }
        
    }
}
