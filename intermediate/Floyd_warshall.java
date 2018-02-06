package intermediate;

public class Floyd_warshall {
	static int INF=99999;
	
	public static void main(String[] args) {
		int graph[][] = { {0,   5,  INF, 10},
		        {INF, 0,   3, INF},
		        {INF, INF, 0,   1},
		        {INF, INF, INF, 0}
		      };
		floydWarshall(graph);
		}

	private static void floydWarshall(int[][] graph) {
		int[][] cost=new int[4][4];
		int[][] path=new int[4][4];
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				cost[i][j]=graph[i][j];
				
				if(i==j)
					path[i][j]=0;
				else
					path[i][j]=j;
			}
		}

		for(int k=0; k<4; k++) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(cost[i][j]>cost[i][k]+cost[k][j]) {
						cost[i][j]=cost[i][k]+cost[k][j];
						path[i][j]=k;
					}
				}
			}
		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(cost[i][j]==INF)
					System.out.print("IN"+"  ");
				else {
					System.out.print(cost[i][j]+"  ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++)
				System.out.print(path[i][j]+"  ");
			System.out.println();
		}
	}
}