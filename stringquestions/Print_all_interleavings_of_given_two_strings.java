package stringquestions;

public class Print_all_interleavings_of_given_two_strings {

	public static void main(String[] args) {
		char str1[] = {'A','B'};
	    char str2[] = {'C','D'};
	    printIls (str1, str2, str1.length, str2.length);
	}

	private static void printIls(char[] str1, char[] str2, int length, int length2) {
		char[] output=new char[length+length2];
		int m=0, n=0;
		printallrecur(str1, str2, length, length2, output, 0, m, n);
	}

	private static void printallrecur(char[] str1, char[] str2, int length, int length2, char[] output, int i, int m, int n) {
		if(length==0 && length2==0)
			System.out.println(String.valueOf(output));
		
		if(length!=0) {
			output[i]=str1[m];
			
			printallrecur(str1, str2, length-1, length2, output, i+1, m+1, n);
		}
		
		if(length2!=0) {
			output[i]=str2[n];
			
			printallrecur(str1, str2, length, length2-1, output, i+1, m, n+1);
		}
	}

}
