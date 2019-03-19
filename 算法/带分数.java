import java.util.Scanner;
public class Main{
	static int ans=0;
	static int N;
	public static void main(String[] args){
		int[] array=new int[]{1,2,3,4,5,6,7,8,9};
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		f(array,0);
		System.out.println(ans);
	}
	public static void f(int[] arr,int k){
		if(k==9){
			check(arr);
			return;
		}
		for(int i=k;i<9;i++){
			int temp=arr[i];arr[i]=arr[k];arr[k]=temp;
			f(arr,k+1);
			temp=arr[i];arr[i]=arr[k];arr[k]=temp;
		}
	}
	public static void check(int[] arr){
		for(int i=1;i<=7;i++){
			int num1=toInt(arr,0,i);
			if(num1>=N)continue;
			for(int j=i+1;j<=8;j++){
				int num2=toInt(arr,i,j);
				int num3=toInt(arr,j,9);
				if((num2%num3==0)&&(num1+num2/num3)==N){
					ans++;
				}
			}
		}
	}
	public static int toInt(int[] arr,int n,int m){
		int t=1;
		int sum=0;
		for(int i=m-1;i>=n;i--){
			sum=sum+arr[i]*t;
			t*=10;
		}
		return sum;
	}
}