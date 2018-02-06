package arrayquestions;

public class Optimal_partition_of_an_array_into_four_parts {

	public static void main(String[] args) {
		int arr[] = {-1, 2, 3};
	    find_Indices(arr, arr.length);
	}

	private static void find_Indices(int[] arr, int length) {
		int[] sum=new int[length+1];
		
		for(int i=1, k=0; i<=length; i++)
			sum[i]=sum[i-1]+arr[k++];
		
		
		int ans=Integer.MIN_VALUE;
		int index1=-1, index2=-1, index3=-1;
		
		for(int l=0; l<=length; l++) {
			
			int vmin=Integer.MAX_VALUE;
			int index=-1;
			
			for(int r=l; r<=length; r++) {
				if(sum[r]<vmin) {
					vmin=sum[r];
					index=r;
				}
				
				
				if(sum[l]+sum[r]-vmin>ans) {
					index1=l;
					index2=index;
					index3=r;
					ans=sum[l]+sum[r]-vmin;
				}
			}
		}
		
		System.out.println(index1+" "+index2+" "+index3+" "+ans);
	}

}
