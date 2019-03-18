public class Main{
	public static void main(String[] args){
		char[] s=new char[]{'a','b','c','d','e','f'};
		reverse(s);
		for(int k=0;k<s.length;k++){
			System.out.print(s[k]+" ");
		}
	}
	public static void reverse(char[] s){
		int start=0;
		int end=s.length-1;
		for(int i=0;i<s.length/2;i++){
			char temp=s[start];
			s[start]=s[end];
			s[end]=temp;
			start++;
			end--;
		}
	}
}