public class Main{
	public static void main(String[] args){
		System.out.println(f(1,1,100));
	}
	static long f(long a,long b,long n){
		if(n==3){
			return a+b;
		}else{
			return f(b,a+b,n-1);
		}
	}
	}
	public static f(int n){
		if(n==1||n==2){
			return 1;
		}else{
			return f(n-1)+f(n-2);
		}
	}	