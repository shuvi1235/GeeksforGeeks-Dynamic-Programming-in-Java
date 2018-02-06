package intermediate;

import java.util.Scanner;

public class Longest_palindromic_subsequence {

	public static void fillmatrix(int [][] a, int len, String s) {
		char carr[]=s.toCharArray();
		
		for(int i=0; i<len; i++)
			for(int j=0; j<len; j++) {
				if(i==j)
					a[i][j]=1;
				else
					a[i][j]=0;
			}
		
		for(int i=2; i<=len; i++) {
			for(int j=0; j<len-i+1; j++) {
				
				int k=j+i-1;
						
				if(carr[j]==carr[k])
					a[j][k]=a[j+1][k-1]+2;
				else
					a[j][k]=Math.max(a[j][k-1], a[j+1][k]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		String s;
		int len;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string: ");
		s=sc.next();
		len=s.length();
		
		int arr[][]=new int[len][len];
		
		fillmatrix(arr, len, s);
		
		/*
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
		*/
		
		System.out.println(arr[0][len-1]);
		
		char[] output=new char[arr[0][len-1]];
		int i=0, j=len-1;
		int k=0, l=arr[0][len-1]-1;
		while(i!=j && k<=l) {
			if(arr[i][j]==arr[i+1][j])
				i++;
			else
				if(arr[i][j]==arr[i][j-1])
					j--;
				else {
					output[k]=s.charAt(j);
					output[l]=s.charAt(j);
					k++; l--;
					i++; j--;
				}		
		}
		output[k]=s.charAt(j);
		output[l]=s.charAt(j);
		
		for(i=0; i<arr[0][len-1]; i++)
			System.out.print(output[i]);
		
		sc.close();
	}

}