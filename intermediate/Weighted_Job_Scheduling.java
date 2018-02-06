package intermediate;

import java.util.Arrays;

public class Weighted_Job_Scheduling {

	public static void main(String[] args) {
		int[] start= {1, 3, 6, 2};
		int[] end=   {2, 5, 19, 100};
		int[] profit= {50, 20, 100, 200};
		
		findmaxprofit(start, end, profit);
	}

	
	private static void findmaxprofit(int[] start, int[] end, int[] profit) {
		int maxprofitindex=-1, maxprofit=Integer.MIN_VALUE;
		int[] totalprofit=profit.clone();
		int[] job=new int[profit.length];
		Arrays.fill(job, -1);
		
		for(int i=1; i<profit.length; i++) {
			for(int j=0; j<i; j++) {
				if(start[i]>=end[j]) {
					if(totalprofit[i]<totalprofit[j]+profit[i]) {
						totalprofit[i]=totalprofit[j]+profit[i];
						job[i]=j;
					}
				}
			}
			if(totalprofit[i]>maxprofit) {
				maxprofit=totalprofit[i];
				maxprofitindex=i;
			}
		}
		
		/*for(int i=0; i<profit.length; i++)
			System.out.print(totalprofit[i]+"  ");
		
		System.out.println();
		
		for(int i=0; i<profit.length; i++)
			System.out.print(job[i]+"  ");
			*/
		
		while(maxprofitindex!=-1) {
			System.out.println("("+start[maxprofitindex]+","+end[maxprofitindex]+") : "+profit[maxprofitindex]);			
			maxprofitindex=job[maxprofitindex];
		}
		
		System.out.print("Maximum Profit: "+maxprofit);
	}
}
