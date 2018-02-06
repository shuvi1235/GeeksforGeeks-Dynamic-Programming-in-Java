package intermediate;

public class bitonic {
	
	public static void bitonicarr(int[] a) {
		int[] temp=new int[a.length];
		int[] temp1=new int[a.length];
		
		for(int i=0; i<a.length; i++) {
			temp[i]=1;
			temp1[i]=1;
		}
		
		int i=1,j=0;
		while(i<a.length) {
			while(j<i) {
				if(a[i]>a[j]) {
					temp[i]=Math.max(temp[i], temp[j]+1);
				}
				j++;
			}
			i++;
			j=0;
		}
		
		i=(a.length-2);
		j=a.length-1;
		while(i>=0) {
			while(j>i) {
				if(a[i]>a[j]) {
					temp1[i]=Math.max(temp1[i], temp1[j]+1);
				}
				j--;
			}
			i--;
			j=a.length-1;
		}
		
		for(int k=0; k<a.length; k++)
			temp[k]=(temp[k]+temp1[k])-1;
		
		for(int k=0; k<a.length; k++)
			System.out.print(temp[k]+" ");
		System.out.println();
		for(int k=0; k<a.length; k++)
			System.out.print(temp1[k]+" ");
		System.out.println();;
		for(int k=0; k<a.length; k++)
			System.out.print(temp[k]+" ");
	}
	

	public static void main(String[] args) {
		int arr[]={1, 11, 2, 10, 4, 5, 2, 1};
		
		bitonicarr(arr);
		
	}

}
