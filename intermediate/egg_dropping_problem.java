package intermediate;

public class egg_dropping_problem {

	public static void main(String[] args) {
        int n = 2, k = 6;
        System.out.println("Minimum number of trials: "+eggDrop(n, k));   
	}

	private static int eggDrop(int n, int k) {
		int[][] a=new int[n+1][k+1];
		
		for(int i=0; i<=n; i++)
			a[i][0]=0;
		
		for(int i=0; i<=k; i++)
			a[0][i]=0;
		
		for(int i=0; i<=k; i++)
			a[1][i]=i;
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(i>j)
					a[i][j]=a[i-1][j];
				else {
					a[i][j]=Integer.MAX_VALUE;
					for(int l=1; l<j; l++) {
						int temp=1+Math.max(a[i-1][l-1], a[i][j-l]);
						
						if(temp<a[i][j])
							a[i][j]=temp;
					}
				}
			}
		}
		

		/*for(int i=0; i<=n; i++) {
			for(int j=0; j<=k; j++)
				System.out.print(a[i][j]+"  ");
			System.out.println();
			}*/
				
		return a[n][k];
	}

}
