package intermediate;

import java.util.Arrays;

public class Building_Bridges {
	


	public static void main(String[] args) {
		int[][] pairs={{0,1,1,2}, {1,3,4,4}};
		
		for(int i=0; i<3; i++) {
			for(int j=i+1; j<4; j++) {
				
				if(pairs[1][i]>pairs[1][j]) {
					int temp=pairs[1][i];
					pairs[1][i]=pairs[1][j];
					pairs[1][j]=temp;
					
					temp=pairs[0][i];
					pairs[0][i]=pairs[0][j];
					pairs[0][j]=temp;
				}
			}
		}
		
		System.out.println();
		
		LIS(pairs, 4);
	}

	private static void LIS(int[][] pairs, int size) {
		int[] a=new int[size];
		int[] path=new int[size];
		Arrays.fill(path, -1);
		Arrays.fill(a, 0);
		
		for(int i=1; i<4; i++) {
			for(int j=0; j<i; j++) {
				if(pairs[0][i]>=pairs[0][j]) {
					a[i]=a[j]+pairs[0][i];
					path[i]=j;
				}
			}
		}
		
	/*for(int i=0; i<4; i++)
		System.out.print(a[i]+" ");
	System.out.println();
	
	for(int i=0; i<4; i++)
		System.out.print(path[i]+" ");
	}*/
		
	int maxindex=-1, max=Integer.MIN_VALUE;
	
	for(int i=0; i<4; i++)
		if(a[i]>max) {
			max=a[i];
			maxindex=i;
		}
	
	System.out.println("Total bridges possible "+max);
	System.out.println("Paths are: ");
	while(path[maxindex]!=-1) {
		System.out.println(pairs[0][maxindex]+"----->"+pairs[1][maxindex]);
		maxindex=path[maxindex];
	 }
	System.out.println(pairs[0][maxindex]+"----->"+pairs[1][maxindex]);
	}

}
