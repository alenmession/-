import java.util.*;
public class Main{
	static int[] weight=new int[]{0,2,2,6,5,4};
	static int[] value=new int[]{0,6,3,5,4,4};
	public static void main(String args[]){
		System.out.println(max_value(5,4));
	}
	static int max_value(int i,int j){
		if(i==0){
			return 0;
		}
		if(j-weight[i]<=0){
			return max_value(i-1,j);
		}else{
			return max(max_value(i-1,j),max_value(i-1,j-weight[i])+value[i]);
		}
	}
	static int max(int n,int m){
		if(n<m){
			int temp=n;
			n=m;
			m=temp;
		}
		return n;
	}
}