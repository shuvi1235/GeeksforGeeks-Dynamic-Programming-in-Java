package intermediate;

import java.util.Arrays;

public class Ugly_number {

	public static void main(String[] args) {
	    int primes[] = {2,5};
	    int n = 5;
	    System.out.println(superUgly(n, primes, 2));
	}

	private static int superUgly(int n, int[] primes, int k) {
		int [] output=new int[n];
		
		int [] counter=new int[primes.length];
		int [] multiple=primes.clone();
	
		Arrays.fill(counter, 0);
		output[0]=1;
		
		for(int i=1; i<n; i++) {
			
			int min=Integer.MAX_VALUE;
			
			//Find Minimum in multiple array
			for(int j=0; j<multiple.length; j++) {
				if(min>multiple[j]) {
					min=multiple[j];
				}
			}
			
			
			//Increment counter of every matching element
			for(int j=0; j<multiple.length; j++) {
				if(min==multiple[j])
					counter[j]++;
			}
			
			//Store value in output array
			output[i]=min;
			
			//Find next multiple of primes
			for(int j=0; j<multiple.length; j++) {
				multiple[j]=primes[j]*output[counter[j]];
			}

		}
		
		/* Print output array
		for(int i=0; i<n; i++) {
			System.out.print(output[i]+"  ");
		}*/
		
		return output[n-1];
	}
}