package stringquestions;

public class Maximum_difference_of_zeros_and_ones {

	public static void main(String[] args) {
		String s="11000010001";
		findmaxsumsubarray(s);
	}

	private static void findmaxsumsubarray(String s) {
		int sum=0, maxsum=0, start=0, end=0;
		
		for(int i=0; i<s.length(); i++) {
			sum+=s.charAt(i)=='0'?1:-1;
			
			if(sum<0) {
				sum=0;
				start=i+1;
				end=i+1;
			}
			//System.out.println(sum+"    "+start+"     "+end);
			
			if(sum>maxsum) {
				maxsum=sum;
				end=i;
			}
		}
		
		System.out.print(maxsum+"   "+s.substring(start,end+1));
	}

}
