package intermediate;

import java.util.Arrays;

public class Bellman_Ford {

	static int INF=Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] graph= {
				{0, 4, 5, 6, INF},
				{INF, 0, -3, INF, INF},
				{INF, INF, 0, INF, 4},
				{INF, INF, INF, 0, 2}, 
				{INF, INF, INF, INF, 0}
				};
		
		bellmanford(graph);
	}
	
	private static void bellmanford(int[][] graph) {
		int[][] weight=new int[5][];
		int[] d=new int[5];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[0]=0;
		int[] p=new int[5];

		for(int i=0; i<5; i++) {
			weight[i]=graph[i].clone();
		}
		
		for(int u=0; u<5; u++) {
			for(int v=1; v<5; v++) {
				if(d[u]==Integer.MAX_VALUE || weight[u][v]==Integer.MAX_VALUE)
					continue;
				else if(d[v]>d[u]+weight[u][v]) {
					d[v]=d[u]+weight[u][v];
					p[v]=u;
				}
			}
		}
		
		for(int i=0; i<5; i++) {
			System.out.print(d[i]+"  ");
		}
		
		System.out.println();
		
		for(int i=0; i<5; i++) {
			System.out.print(p[i]+"  ");
		}
	}

}
