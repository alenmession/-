public class Main{
	public static void main(String[] args){
		System.out.println(f(4));
	}
	public static int f(int n){
		if(n==1)return 1;
		if(n==2)return 2;
		return f(n-1)+f(n-2);
	}
}