package stringquestions;

public class minwindow {
	
	static void findwindow(String str, String pat) {
		int[] strhash=new int[256];
		int[] pathash=new int[256];
		int count=0, start=-1, minwindowlen=0, s=0, min_len=Integer.MAX_VALUE;
		
		for(int i=0; i<pat.length(); i++)
			pathash[pat.charAt(i)]++;
		
		for(int i=0; i<str.length(); i++) {
			strhash[str.charAt(i)]++;
			
			if(pathash[str.charAt(i)]!=0 && strhash[str.charAt(i)]<=pathash[str.charAt(i)])
				count++;
			
			if(count==pat.length()) {
				
				while(pathash[str.charAt(s)]==0 || pathash[str.charAt(s)]<strhash[str.charAt(s)]) {
					
					if(pathash[str.charAt(s)]==0)
						s++;
					
					if(strhash[str.charAt(s)]>pathash[str.charAt(s)]) {
						strhash[str.charAt(s)]--;
						s++;
					}
				}
				
				minwindowlen=i-s+1;
				
				if(minwindowlen<min_len) {
					start=s;
					min_len=minwindowlen;
				}
			}
		}
		
		
		System.out.print(str.substring(start, start+min_len));
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		String pat = "ork";

		findwindow(str, pat);
	}

}
