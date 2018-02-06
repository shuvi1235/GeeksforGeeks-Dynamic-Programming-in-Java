package arrayquestions;

public class Minimum_pair_sum_operations_to_make_array_each_element_divisible_by_4 {

	public static void main(String[] args) {
		int arr[] = {4, 2, 2, 6, 6};
	    int n = arr.length;
	    System.out.println(minimumOperations(arr, n));
	}

	private static int minimumOperations(int[] arr, int n) {
		int[] rem=new int[4];
		
		for(int i=0; i<arr.length; i++)
			rem[arr[i]%4]++;
		
		if((rem[1]+2*rem[2]+3*rem[3])%4==0) {
			int min_opr=Math.min(rem[1], rem[3]);
			
			min_opr+=rem[2]/2;
			rem[2]=rem[2]%2;
			
			if(rem[2]==1) {
				min_opr+=2;
				rem[2]=0;
				
				if(rem[1]>1)
					rem[1]-=2;
				
				if(rem[3]>1)
					rem[3]-=2;
				
			}
			
			if(rem[1]>0)
				min_opr+=(rem[1]/4)*3;
			
			if(rem[3]>0)
				min_opr+=(rem[3]/4)*3;
			
			return min_opr;
			
		}
		return 0;
	}
}
