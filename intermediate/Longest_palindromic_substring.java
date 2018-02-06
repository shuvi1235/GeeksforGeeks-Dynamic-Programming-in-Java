package intermediate;

import java.util.Scanner;

public class Longest_palindromic_substring {

	public static void fillmatrix(boolean [][] a, int len, String s) {
		
		char carr[]=s.toCharArray();
		int start=0, maxlen=1;
		
		for(int i=0; i<len; i++)
			for(int j=0; j<len; j++) {
				if(i==j)
					a[i][j]=true;
				else
					a[i][j]=false;
			}
		
		
		
		for(int i=2; i<=len; i++) {
			for(int j=0; j<len-i+1; j++) {
				
				int k=j+i-1;
				if(carr[j]==carr[k] && i==2) {
					a[j][k]=true;
					
					if(i>maxlen) {
						maxlen=i;
						start=j;
					}
				}
				else if(a[j+1][k-1] && carr[j]==carr[k]) {
					a[j][k]=true;
					
					if(i>maxlen) {
						maxlen=i;
						start=j;
					}
				}
			}
		}	
		
		System.out.print(s.substring(start, start+maxlen));
	}
	
	public static void main(String[] args) {
		String s="aba";
		int len;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string: ");
		//s=sc.next();
		len=s.length();
		
		boolean arr[][]=new boolean[len][len];
		
		fillmatrix(arr, len, s);
		
		
		/*for(int i=0; i<len; i++){
			for(int j=0; j<len; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}*/
		sc.close();
	}

}