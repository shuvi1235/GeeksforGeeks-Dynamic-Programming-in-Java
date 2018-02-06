package stringquestions;

import java.io.IOException;

public class Merge_two_strings_in_chunks_of_given_size {
	
    public static void main(String args[])
            throws IOException
        {
            String a = "determination", b = "stance";
            int k = 3;
            System.out.print(solve(a.toCharArray(), b.toCharArray(), k));
        }

	private static String solve(char[] a, char[] b, int k) {
		int u=0, v=0, w=0;
		char[] output=new char[a.length+b.length];
		
		while(u<a.length && v<b.length) {
			int x=u+k;
			while(u<x && u<a.length) {
				output[w++]=a[u++];
			}
			
			x=v+k;
			while(v<x && v<b.length) {
				output[w++]=b[v++];
			}
		}
		
		while(u<a.length)
			output[w++]=a[u++];

		while(v<b.length)
			output[w++]=b[v++];
		
		return String.valueOf(output);
	}
}
