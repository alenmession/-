import java.math.*;
import java.util.*;
public class Main{
	static int[] x=new int[1000];//x[i]表示皇后放置在第i行第想x[i]列
	static int count=0;
	static int n=4;
	public static void main(String[] args){
		f(1);
		System.out.println(count);
	}
	public static boolean check(int t){//判断皇后能否放在某一位置
		boolean flag=true;
		for(int i=1;i<t;i++){//判断现在放的皇后与已放置的皇后的位置是否冲突
			if(x[t]==x[i]||t-i==Math.abs(x[t]-x[i])){//判断列，对角是否冲突
				flag=false;
				break;
			}
		}
		return flag;
	}
	public static void f(int t){
		if(t>n){
			count++;
			System.out.print("皇后位置：");
			for(int k=1;k<=n;k++){
				System.out.print(x[k]+" ");
			}
			System.out.println();
		}else{
			for(int i=1;i<=n;i++){
				x[t]=i;//将皇后放在第i列
				if(check(t)){//检查皇后的位置是否合法
					f(t+1);
				}
			}
		}
	}
}