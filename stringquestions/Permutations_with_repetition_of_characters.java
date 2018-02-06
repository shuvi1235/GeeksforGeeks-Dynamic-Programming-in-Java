package stringquestions;

import java.util.Arrays;

public class Permutations_with_repetition_of_characters {

	public static void main(String[] args) {
		char str[] = { 'b', 'c', 'a' };
		allLexicographic(str);
	}

	private static void allLexicographic(char[] str) {
		int start = 0, len = str.length;
		char[] output = new char[len];
		Arrays.sort(str);
		
		printpermutation(str, start, len-1, output);
	}

	private static void printpermutation(char[] str, int start, int len, char[] output) {

		int size=str.length;
		
		for (int i = 0; i < size; i++) {
			output[start] = str[i];

			if (start == len) {
				System.out.println(new String(output));
			} else
				printpermutation(str, start + 1, len, output);
		}
	}

}
