package intermediate;

import java.util.Arrays;

public class Longest_substring_without_repeating_characters {

	public static void main(String[] args) {
		String str = "ABDEFGABEF";
	    System.out.println("The input string is "+str);
	    longestUniqueSubsttr(str);
	}

	private static void longestUniqueSubsttr(String str) {
		boolean[] visited=new boolean[256];
		Arrays.fill(visited, false);
		int start=0, length=0, temp=0;
		
		for(int i=0; i<str.length(); i++) {
			if(visited[str.charAt(i)]==false) {
				visited[str.charAt(i)]=true;
				temp++;
			} else {
			    //System.out.print(temp+" ");
				if(temp>length) {
					length=temp;
					start=i-length;
					temp=1;
					Arrays.fill(visited, false);
				}
			}
		}
		
		System.out.print(str.substring(start, start+length)+"    "+length);
	}

}