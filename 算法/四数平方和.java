import java.util.*;
import java.math.*;
public class Main{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		Map<Integer,Integer> staff=new HashMap<Integer,Integer>();
		int N=s.nextInt();
		for(int c=0;c*c<=N/2;++c){
			for(int d=c;c*c+d*d<=N;++d){
				if(!staff.containsKey(c*c+d*d)){
					staff.put(c*c+d*d,c);
				}
			}
		}
		for(int a=0;a*a<=N/4;++a){
			for(int b=a;b*b+a*a<=N/2;++b){
			if(staff.containsKey(N-a*a-b*b)){
					int c=staff.get(N-a*a-b*b);
					int d=(int)Math.sqrt(N-a*a-b*b-c*c);
					System.out.println(a+" "+b+" "+c+" "+d);
					System.exit(0);
				}
			}
		}
	}
}