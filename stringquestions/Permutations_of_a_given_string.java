package stringquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Permutations_of_a_given_string {

	public static void main(String[] args) {
		String input="ABC";
		ArrayList<String> ar=new ArrayList<String>();
		char[] s=input.toCharArray();
		permute(s, 0, s.length-1,ar);
		System.out.println(ar);
		Collections.sort(ar);
		
		String output="";
		Iterator<String> itr=ar.iterator();
		while(itr.hasNext()) {
			output+=itr.next();
		}
		System.out.println(output);

	}

	private static void permute(char[] s, int l, int r, ArrayList<String> ar) {
		if(l==r)
			ar.add(String.valueOf(s));
		else {
			for(int i=l; i<=r; i++) {
				s=swap(s,l,i);
				permute(s,l+1,r,ar);
				s=swap(s,l,i);
			}
		}
	}

	private static char[] swap(char[] s, int l, int i) {
		char temp=s[i];
		s[i]=s[l];
		s[l]=temp;
		return s;
	}

}
