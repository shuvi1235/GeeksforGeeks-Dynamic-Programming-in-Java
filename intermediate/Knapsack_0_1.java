package intermediate;

import java.util.ArrayList;

public class Knapsack_0_1 {
	
	public static int knapSack(int w, int[] wt, int[] val) {
		if(w==0) {
			System.out.print("Max: 0");
			return 0;
		}
		
		int[][] k=new int[val.length+1][w+1];
		
		for(int i=0 ; i<=val.length; i++) {
			for(int j=0; j<=w; j++) {
			    
				if(i==0 || j==0)
					k[i][j]=0;
				else if(wt[i-1]<=j)
					k[i][j]=Math.max(val[i-1]+k[i-1][j-wt[i-1]], k[i-1][j]);
				else
					k[i][j]=k[i-1][j];
			}
		}
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		for(int i=0 ; i<=val.length; i++) {
			for(int j=0; j<=w; j++)
				System.out.print(k[i][j]+"    ");
			System.out.println();
		}
		
		int i=val.length;
		int j=w;
		
		while(i!=0 || j!=0) {
			if(k[i][j]==k[i-1][j]) {
				//System.out.println(i+" "+j+"    "+wt[i-1]+" skip");
				i=i-1;
				continue;
			} else {
				arr.add(wt[i-1]);
				//System.out.println(i+" "+j+"    "+wt[i-1]+" add");
				i=i-1;
				j=j-wt[i];
				
			}
		}
		
		System.out.println("max value: "+k[val.length][w]+" by adding weight "+arr);
		
		return 0;
	}

	public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
	    knapSack(W, wt, val);
	    System.out.println();
	    return;
	}
}