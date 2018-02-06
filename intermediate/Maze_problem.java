package intermediate;

import java.util.Arrays;

public class Maze_problem {

	public static void main(String[] args) {
	        int maze[][] = {{1,  1, 1, 1},
                    {1, 0, 1, 1},
                    {0, 1, 1, 1},
                    {1,  1, 1, 1}};
	        
	        solveUtil(maze, maze.length, maze[0].length);
	    }
	
	public static void printsol(int[][] sol) {
		for(int i=0; i<sol.length; i++) {
			for(int j=0; j<sol[i].length; j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isSafe(int N, int M, int[][] maze, int x, int y) {
		return (x<N && y<M && x>=0 && y>=0 && maze[x][y]==1);
	}
	
	public static void solveUtil(int[][] maze, int N, int M) {
		int count=0;
		int[][] sol=new int[N][M];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(sol[i], 0);
		}
		
		if(solveMaze(maze, N, M, 0, 0, sol, count)==false) {
			System.out.print("Solution does not exist");
			return;
		}
		
		printsol(sol);	
	}

	private static boolean solveMaze(int[][] maze, int N, int M, int x, int y, int[][] sol, int count) {
		if(x==N-1 && y==M-1) {
			sol[x][y]=1;
			return true;
		}
			if(isSafe(N, M, maze, x, y)) {
				sol[x][y]=1;
				
				if(solveMaze(maze, N, M, x+1, y, sol, count))
					return true;
				
				if(solveMaze(maze, N, M, x, y+1, sol, count))
					return true;
				
				sol[x][y]=0;
				return false;
		}
		return false;
	}

}
