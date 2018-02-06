package intermediate;

import java.util.Arrays;

public class Box_Stacking {

	public static void main(String[] args) {
		int[][] lwh= {{4, 6, 7},{1, 2, 3},{4, 5, 6},{10, 12, 32}};
		maxheight(lwh, 4);
	}

	private static void maxheight(int[][] lwh, int i) {
		int[][] rotation= new int[i*3][3];
		int[] area=new int[i*3];
		int[] maxheight=new int[i*3];
		int[] path=new int[i*3];
		
		int k=0;
		for(int j=0; j<4; j++) {
			
			rotation[k]=new int[] {Math.max(lwh[j][1],lwh[j][2]), Math.min(lwh[j][1],lwh[j][2]),lwh[j][0]}; k++;
			rotation[k]=new int[] {Math.max(lwh[j][2],lwh[j][0]),Math.min(lwh[j][2],lwh[j][0]),lwh[j][1]}; k++;
			rotation[k]=new int[] {Math.max(lwh[j][1],lwh[j][0]), Math.min(lwh[j][1],lwh[j][0]),lwh[j][2]}; k++;
			}
		
		for(int j=0; j<12; j++)
			area[j]=rotation[j][0]*rotation[j][1];
		
		for(int j=0; j<11; j++)
			for(int l=j+1; l<12; l++)
				if(area[j]<area[l]) {
					area[j]+=area[l];
					area[l]=area[j]-area[l];
					area[j]=area[j]-area[l];
					
					int[] temp=rotation[j].clone();
					rotation[j]=rotation[l].clone();
					rotation[l]=temp.clone();
				}
		
		for(int j=0; j<12; j++)
			maxheight[j]=rotation[j][2];
		
		Arrays.fill(path, -1);
		
		
		
		/*for(int j=0; j<12; j++)
			System.out.print(area[j]+" ");
			
		
		System.out.println();
		
		for(int j=0; j<k; j++) {
			for(int l=0; l<3; l++)
				System.out.print(rotation[j][l]+"  ");
			System.out.println();
		}
		*/
		
		for(int j=1; j<12; j++) {
			for(int l=0; l<j; l++) {
				if(rotation[l][0]>rotation[j][0] && rotation[l][1]>rotation[j][1])
					if(maxheight[j]<maxheight[l]+rotation[j][2]) {
						maxheight[j]=maxheight[l]+rotation[j][2];
						path[j]=l;
					}
			}
		}
		
		int max=0, maxindex=-1;
		for(int j=0; j<12; j++)
			if(max<maxheight[j]) {
				max=maxheight[j];
				maxindex=j;
			}

		System.out.println("Maximum height: "+max);
		System.out.println("Box Used: ");
		while(path[maxindex]!=-1) {
			System.out.println(rotation[maxindex][0]+" "+rotation[maxindex][1]+" "+rotation[maxindex][2]);
			maxindex=path[maxindex];
		}
		System.out.println(rotation[maxindex][0]+" "+rotation[maxindex][1]+" "+rotation[maxindex][2]);
		return;
	}

}
