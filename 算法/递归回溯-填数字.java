import java.util.*;
import java.math.*;
public class Main{
	static int count=0;
	static int[] a=new int[]{0,1,2,3,4,5,6,7,8,9};
	public static void main(String args[]){
		f(0);
		System.out.println(count);
	}
	public static boolean cheak(){
		 	if (Math.abs(a[1]-1)==a[0]||Math.abs(a[5]-1)==a[0]||Math.abs(a[4]-1)==a[0]||Math.abs(a[3]-1)==a[0]){
			 return false;
			}else if(Math.abs(a[0]-1)==a[1]||Math.abs(a[2]-1)==a[1]||Math.abs(a[6]-1)==a[1]||Math.abs(a[5]-1)==a[1]||Math.abs(a[4]-1)==a[1]){
			 return false;
			}else if(Math.abs(a[1]-1)==a[2]||Math.abs(a[6]-1)==a[2]||Math.abs(a[5]-1)==a[2]){
				return false;
			}else if(Math.abs(a[0]-1)==a[3]||Math.abs(a[4]-1)==a[3]||Math.abs(a[8]-1)==a[3]||Math.abs(a[7]-1)==a[3]){
				return false;
			}else if(Math.abs(a[0]-1)==a[4]||Math.abs(a[1]-1)==a[4]||Math.abs(a[5]-1)==a[4]||Math.abs(a[9]-1)==a[4]||Math.abs(a[8]-1)==a[4]||Math.abs(a[7]-1)==a[4]||Math.abs(a[3]-1)==a[4]){
				return false;
			}else if(Math.abs(a[0]-1)==a[5]||Math.abs(a[1]-1)==a[5]||Math.abs(a[6]-1)==a[5]||Math.abs(a[9]-1)==a[5]||Math.abs(a[8]-1)==a[5]||Math.abs(a[4]-1)==a[5]||Math.abs(a[2]-1)==a[5]){
				return false;
			}else if(Math.abs(a[1]-1)==a[6]||Math.abs(a[2]-1)==a[6]||Math.abs(a[5]-1)==a[6]||Math.abs(a[9]-1)==a[6]){
				return false;
			}else if(Math.abs(a[3]-1)==a[7]||Math.abs(a[4]-1)==a[7]||Math.abs(a[8]-1)==a[7]){
				return false;
			}else if(Math.abs(a[3]-1)==a[8]||Math.abs(a[4]-1)==a[8]||Math.abs(a[5]-1)==a[8]||Math.abs(a[9]-1)==a[8]||Math.abs(a[7]-1)==a[8]){
				return false;
			}else if(Math.abs(a[4]-1)==a[9]||Math.abs(a[5]-1)==a[9]||Math.abs(a[8]-1)==a[9]||Math.abs(a[6]-1)==a[9]){
				return false;
			}else{
				return true;
			}
	}
	static void f(int num){
		if(num==10){
			if(cheak()){
				count++;
			}
			return;
		}
		for(int i=num;i<10;i++){
			{
				int temp=a[num];
				a[num]=a[i];
				a[i]=temp;
			}
			f(num+1);
			{
				int temp=a[num];
				a[num]=a[i];
				a[i]=temp;
			}
		}
	}
}